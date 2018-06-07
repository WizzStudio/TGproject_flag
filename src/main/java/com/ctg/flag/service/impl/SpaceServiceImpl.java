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
        List<SpaceApply> sa = spaceApplyDao.getByUidAndStateIn(uid, states);
        sa.sort((a, b) -> b.getCreateTime().compareTo(a.getCreateTime()));
        if (sa.size() != 0) {
            sa.get(0).setState(SpaceApplyStateEnum.PENDING_DELETED.getValue());
            spaceApplyDao.save(sa.get(0));
        }
        spaceApplyDao.save(spaceApply);
    }

    @Override
    public SpaceApply getPendingSpaceApplyByUid(Integer uid) {
        List<Integer> states = new ArrayList<>();
        states.add(SpaceApplyStateEnum.PENDING.getValue());
        states.add(SpaceApplyStateEnum.ACCEPTING.getValue());
        states.add(SpaceApplyStateEnum.REFUSED.getValue());

        List<SpaceApply> list = spaceApplyDao.getByUidAndStateIn(uid, states);
        list.sort((a, b) -> b.getCreateTime().compareTo(a.getCreateTime()));
        return list.get(0);
    }

    @Override
    public void deleteSpaceApplyByUid(Integer uid) {
        List<Integer> states = new ArrayList<>();
        states.add(SpaceApplyStateEnum.PENDING.getValue());
        states.add(SpaceApplyStateEnum.ACCEPTING.getValue());
        states.add(SpaceApplyStateEnum.REFUSED.getValue());

        List<SpaceApply> spaceApplys = spaceApplyDao.getByUidAndStateIn(uid, states);
        if (spaceApplys.size() == 0) return;

        spaceApplys.sort((a, b) -> b.getCreateTime().compareTo(a.getCreateTime()));
        SpaceApply spaceApply = spaceApplys.get(0);

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
