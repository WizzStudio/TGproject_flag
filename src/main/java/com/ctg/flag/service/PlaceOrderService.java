package com.ctg.flag.service;

import com.ctg.flag.pojo.dto.OptionDto;
import com.ctg.flag.pojo.dto.OrderManageDto;
<<<<<<< HEAD
import com.ctg.flag.pojo.entity.Place;
=======
import com.ctg.flag.pojo.dto.PlaceOrderDetailDto;
>>>>>>> c7fc44bee253bb856cbcf90b6339606dcf3d5d5b
import com.ctg.flag.pojo.entity.PlaceOrder;

import java.util.List;

public interface PlaceOrderService {
    List<OptionDto<Integer, OrderManageDto>> listPlaceOfOrderByUid(Integer id);

    void save(PlaceOrder placeOrder);

<<<<<<< HEAD
    PlaceOrder findById(Integer pid);
=======
    PlaceOrderDetailDto getPlaceOrderById(Integer oid);
>>>>>>> c7fc44bee253bb856cbcf90b6339606dcf3d5d5b
}
