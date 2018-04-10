package com.ctg.flag.web.controller;

import com.ctg.flag.enums.CouncilStateEnum;
import com.ctg.flag.pojo.dto.CouncilOrderListDto;
import com.ctg.flag.pojo.dto.OptionDto;
import com.ctg.flag.pojo.dto.ResponseDto;
import com.ctg.flag.pojo.entity.CouncilOrder;
import com.ctg.flag.service.CouncilOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/councilOrder")
public class CouncilOrderController {
    private CouncilOrderService councilOrderService;

    @Autowired
    public CouncilOrderController(CouncilOrderService councilOrderService) {
        this.councilOrderService = councilOrderService;
    }

    /**
     * 提交会务室申请
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseDto postCouncilOrder(CouncilOrder councilOrder, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        councilOrder.setUid(userId);
        councilOrder.setState(CouncilStateEnum.PENDING.getValue());

        councilOrderService.save(councilOrder);
        return ResponseDto.succeed();
    }

    /**
     * 获得自己提交过的申请
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseDto getCouncilOrderList(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");

        List<CouncilOrderListDto> councils = councilOrderService.listCouncilStateByUid(userId);
        return ResponseDto.succeed(null, councils);
    }
}
