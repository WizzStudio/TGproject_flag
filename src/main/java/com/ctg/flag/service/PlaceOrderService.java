package com.ctg.flag.service;

import com.ctg.flag.pojo.dto.OptionDto;
import com.ctg.flag.pojo.dto.OrderManageDto;

import com.ctg.flag.pojo.dto.PlaceOrderDetailDto;
import com.ctg.flag.pojo.entity.PlaceOrder;

import java.util.List;

public interface PlaceOrderService {
    /**
     * 通过用户id获得该用户所有未删除订单
     */
    List<OptionDto<Integer, OrderManageDto>> listPlaceOfOrderByUid(Integer id);

    /**
     * 保存预约订单
     */
    void save(PlaceOrder placeOrder);

    /**
     *
     * 状态码小于state的预约事件
     */
    List<PlaceOrder> personOrderNum(int state);

    /**
     *
     * id的成功预约的事件
     * 即id状态码等于4的事件
     *
     */
    List<PlaceOrder> successOrderNum(int id,int state);


    PlaceOrder getPlaceOrderById(Integer pid);

    /**
     * 通过订单id查询未删除的订单详情
     */
    PlaceOrderDetailDto getExistedPlaceOrderById(Integer oid);


}
