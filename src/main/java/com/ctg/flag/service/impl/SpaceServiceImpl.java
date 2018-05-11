package com.ctg.flag.service.impl;

import com.ctg.flag.dao.SpaceApplyDao;
import com.ctg.flag.enums.SpaceApplyStateEnum;
import com.ctg.flag.pojo.entity.SpaceApply;
import com.ctg.flag.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpaceServiceImpl implements SpaceService{
    private SpaceApplyDao spaceApplyDao;

    @Autowired
    public SpaceServiceImpl(SpaceApplyDao spaceApplyDao) {
        this.spaceApplyDao = spaceApplyDao;
    }

    @Override
    public void saveSpaceApply(Integer uid, SpaceApply spaceApply) {
        List<Integer> states = new ArrayList<>();
        states.add(SpaceApplyStateEnum.PENDING.getValue());
        states.add(SpaceApplyStateEnum.ACCEPTING.getValue());
        states.add(SpaceApplyStateEnum.REFUSED.getValue());
        SpaceApply sa = spaceApplyDao.getByUidAndStateIn(uid, states);
        if (sa != null) {
            sa.setState(SpaceApplyStateEnum.PENDING_DELETED.getValue());
            spaceApplyDao.save(sa);
        }
        spaceApplyDao.save(spaceApply);
    }

    @Override
    public SpaceApply getPendingSpaceApplyByUid(Integer uid) {
        List<Integer> states = new ArrayList<>();
        states.add(SpaceApplyStateEnum.PENDING.getValue());
        states.add(SpaceApplyStateEnum.ACCEPTING.getValue());
        states.add(SpaceApplyStateEnum.REFUSED.getValue());

        return spaceApplyDao.getByUidAndStateIn(uid, states);
    }

    @Override
    public void deleteSpaceApplyByUid(Integer uid) {
        List<Integer> states = new ArrayList<>();
        states.add(SpaceApplyStateEnum.PENDING.getValue());
        states.add(SpaceApplyStateEnum.ACCEPTING.getValue());
        states.add(SpaceApplyStateEnum.REFUSED.getValue());

        SpaceApply spaceApply = spaceApplyDao.getByUidAndStateIn(uid, states);
        if (spaceApply.getState().equals(SpaceApplyStateEnum.PENDING.getValue())) {
            spaceApply.setState(SpaceApplyStateEnum.PENDING_DELETED.getValue());
        } else if (spaceApply.getState().equals(SpaceApplyStateEnum.ACCEPTING.getValue())) {
            spaceApply.setState(SpaceApplyStateEnum.ACCEPTED_DELETED.getValue());
        } else {
            spaceApply.setState(SpaceApplyStateEnum.REFUSED_DELETED.getValue());
        }
        spaceApplyDao.save(spaceApply);
    }

    @Override
    public Boolean existsByUidAndStateIn(Integer uid) {
        List<Integer> states = new ArrayList<>();
        states.add(SpaceApplyStateEnum.PENDING.getValue());
        states.add(SpaceApplyStateEnum.ACCEPTING.getValue());
        states.add(SpaceApplyStateEnum.REFUSED.getValue());

        return spaceApplyDao.existsByUidAndStateIn(uid, states);
    }
}
