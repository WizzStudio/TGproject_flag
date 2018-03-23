package com.ctg.flag.web.controller;

import com.ctg.flag.pojo.dto.OptionDto;
import com.ctg.flag.pojo.dto.OrderManageDto;
import com.ctg.flag.pojo.dto.ResponseDto;
import com.ctg.flag.pojo.entity.PlaceOrder;
import com.ctg.flag.pojo.entity.User;
import com.ctg.flag.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/placeOrder")
public class PlaceOrderController {
    private final PlaceOrderService placeOrderService;

    @Autowired
    public PlaceOrderController(PlaceOrderService placeOrderService) {
        this.placeOrderService = placeOrderService;
    }

    /**
     * 提交场地预约
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseDto postPlaceOrder(PlaceOrder placeOrder, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseDto.failed("not log in");
        }
        placeOrder.setUid(user.getId());
        placeOrderService.save(placeOrder);

        return ResponseDto.succeed("save successfully");
    }

    /**
     * 获得用户预约管理
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseDto getPlaceOrder(HttpSession session) {
        User user = (User) session.getAttribute("user");
//        if (user == null) {
//            return ResponseDto.failed("not log in");
//        }

        user = new User();
        user.setId(1);
        List<OptionDto<Integer, OrderManageDto> > list = placeOrderService.listPlaceOfOrderByUid(user.getId());
        list.forEach((opt) -> {
            Map map = (Map) opt.getOptVal();
            System.out.println(map.get("createTime"));
        });
        return ResponseDto.succeed(null, list);
    }


}
