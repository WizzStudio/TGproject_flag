package com.ctg.flag.web.controller;

import com.ctg.flag.enums.PlaceOrderStateEnum;
import com.ctg.flag.pojo.dto.OptionDto;
import com.ctg.flag.pojo.dto.OrderManageDto;
import com.ctg.flag.pojo.dto.PlaceOrderDetailDto;
import com.ctg.flag.pojo.dto.ResponseDto;
import com.ctg.flag.pojo.entity.PlaceOrder;
import com.ctg.flag.service.PlaceOrderService;
import com.ctg.flag.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/placeOrder")
public class PlaceOrderController {
    private final PlaceOrderService placeOrderService;
    private final UserService userService;

    @Autowired
    public PlaceOrderController(PlaceOrderService placeOrderService, UserService userService) {
        this.placeOrderService = placeOrderService;
        this.userService = userService;
    }

    /**
     * 提交场地预约
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseDto postPlaceOrder(PlaceOrder placeOrder, HttpSession session) {
        Integer uid = (Integer) session.getAttribute("userId");
        if (uid == null) {
            return ResponseDto.failed("not log in");
        }
        placeOrder.setUid(uid);
        placeOrderService.save(placeOrder);

        return ResponseDto.succeed("save successfully");
    }

    /**
     * 获得用户预约管理
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseDto getPlaceOrder(HttpSession session) {
        Integer uid = (Integer) session.getAttribute("userId");
        if (uid == null) {
            return ResponseDto.failed("not log in");
        }

        List<OptionDto<Integer, OrderManageDto> > list = placeOrderService.listPlaceOfOrderByUid(uid);
        list.sort((opt1, opt2) -> {
            OrderManageDto o1 = opt1.getOptVal();
            OrderManageDto o2 = opt2.getOptVal();
            return o1.getCreateTime().compareTo(o2.getCreateTime());
        });

        return ResponseDto.succeed(null, list);
    }

    /**
     * 取消预约场地
     * @param oid
     * @return
     */
    @RequestMapping(value = "/{oid}",method = RequestMethod.DELETE)
   public ResponseDto cancelPlaceOrder(@PathVariable(name = "oid") Integer oid ){
        //1、根据场地id获取一个placeOrder对象
       PlaceOrder placeOrder=placeOrderService.findById(oid);
       if (placeOrder==null){//若id错误，则返回查询失败码：1
           ResponseDto.failed();
       }
       if (!placeOrder.getState().equals(PlaceOrderStateEnum.DELETED.getValue())) {
           placeOrder.setState(PlaceOrderStateEnum.DELETED.getValue());
           placeOrderService.save(placeOrder);
           return ResponseDto.succeed();
       }else {
            return ResponseDto.failed();
       }
   }
    /**
     * 获取订单详情
     */
    @RequestMapping(value = "/{oid}", method = RequestMethod.GET)
    public ResponseDto getPlaceOrderDetail(@PathVariable(name = "oid") Integer oid, HttpSession session) {
        Integer uid = (Integer) session.getAttribute("userId");
        if (uid == null) {
            return ResponseDto.failed("not log in");
        }

        PlaceOrderDetailDto placeOrderDetailDto = placeOrderService.getPlaceOrderById(oid);
        if (placeOrderDetailDto == null) {
            return ResponseDto.failed("placeOrderId = " + oid + " not existed");
        } else {
            return ResponseDto.succeed(null, placeOrderDetailDto);
        }
    }

}
