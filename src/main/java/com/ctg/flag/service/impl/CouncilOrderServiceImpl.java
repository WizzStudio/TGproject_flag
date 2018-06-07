package com.ctg.flag.service.impl;

import com.ctg.flag.dao.CouncilOrderDao;
import com.ctg.flag.dao.projection.CouncilOrderStatusProjection;
import com.ctg.flag.enums.CouncilStateEnum;
import com.ctg.flag.pojo.dto.CouncilOrderListDto;
import com.ctg.flag.pojo.entity.CouncilOrder;
import com.ctg.flag.service.CouncilOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CouncilOrderServiceImpl implements CouncilOrderService{
    private CouncilOrderDao councilOrderDao;

    @Autowired
    public CouncilOrderServiceImpl(CouncilOrderDao councilOrderDao) {
        this.councilOrderDao = councilOrderDao;
    }

    @Override
    public void save(CouncilOrder councilOrder) {
        councilOrderDao.save(councilOrder);
    }

    @Override
    public List<CouncilOrderListDto> listCouncilStateByUid(Integer userId) {
        List<CouncilOrder> councils = councilOrderDao.findAllByUid(userId);
        List<CouncilOrderListDto> cl = new ArrayList<>();
        councils.forEach(c -> {
            cl.add(new CouncilOrderListDto(c.getId(), c.getTeamName(), c.getCreateTime(), c.getState()));
        });
        cl.sort(Comparator.comparing(CouncilOrderListDto::getCreateTime).reversed());
        return cl;
    }

    @Override
    public List<CouncilOrderStatusProjection> getOrderStatus(Integer userId) {
        return councilOrderDao.getByUidOrderByStartTimeDesc(userId);
    }
}
