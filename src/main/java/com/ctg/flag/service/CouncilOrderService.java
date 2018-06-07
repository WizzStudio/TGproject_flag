package com.ctg.flag.service;

import com.ctg.flag.dao.projection.CouncilOrderStatusProjection;
import com.ctg.flag.pojo.dto.CouncilOrderListDto;
import com.ctg.flag.pojo.dto.OptionDto;
import com.ctg.flag.pojo.entity.CouncilOrder;

import java.util.List;

public interface CouncilOrderService {

    void save(CouncilOrder councilOrder);

    List<CouncilOrderListDto> listCouncilStateByUid(Integer userId);

    List<CouncilOrderStatusProjection> getOrderStatus(Integer userId);
}
