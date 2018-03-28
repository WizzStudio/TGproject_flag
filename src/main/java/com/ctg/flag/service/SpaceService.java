package com.ctg.flag.service;

import com.ctg.flag.pojo.entity.SpaceApply;

public interface SpaceService {
    void saveSpaceApply(SpaceApply spaceApply);

    SpaceApply getSpaceApplyByUid(Integer uid);

    Boolean existsByUidAndStateNot(Integer uid, Integer value);
}
