package com.ctg.flag.service;

import com.ctg.flag.pojo.dto.OptionDto;
import com.ctg.flag.pojo.dto.OrderManageDto;

import com.ctg.flag.pojo.entity.Place;
import com.ctg.flag.pojo.dto.PlaceOrderDetailDto;
import com.ctg.flag.pojo.entity.PlaceOrder;

import java.util.List;

public interface PlaceOrderService {
    List<OptionDto<Integer, OrderManageDto>> listPlaceOfOrderByUid(Integer id);

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

    PlaceOrder findById(Integer pid);

    PlaceOrderDetailDto getExistedPlaceOrderById(Integer oid);
}
