package com.ctg.flag.service.impl;

import com.ctg.flag.dao.SpaceApplyDao;
import com.ctg.flag.pojo.entity.SpaceApply;
import com.ctg.flag.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpaceServiceImpl implements SpaceService{
    SpaceApplyDao spaceApplyDao;

    @Autowired
    public SpaceServiceImpl(SpaceApplyDao spaceApplyDao) {
        this.spaceApplyDao = spaceApplyDao;
    }

    @Override
    public void saveSpaceApply(SpaceApply spaceApply) {
        spaceApplyDao.save(spaceApply);
    }

    @Override
    public SpaceApply getSpaceApplyByUid(Integer uid) {
        return spaceApplyDao.getByUid(uid);
    }

    @Override
    public Boolean existsByUidAndStateNot(Integer uid, Integer value) {
        return spaceApplyDao.existsByUidAndStateNot(uid, value);
    }

}
