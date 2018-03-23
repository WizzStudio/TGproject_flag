package com.ctg.flag.service;

import com.ctg.flag.pojo.dto.OptionDto;
import com.ctg.flag.pojo.dto.OrderManageDto;
import com.ctg.flag.pojo.entity.Place;
import com.ctg.flag.pojo.entity.PlaceOrder;

import java.util.List;

public interface PlaceOrderService {
    List<OptionDto<Integer, OrderManageDto>> listPlaceOfOrderByUid(Integer id);

    void save(PlaceOrder placeOrder);

    PlaceOrder findById(Integer pid);
}
