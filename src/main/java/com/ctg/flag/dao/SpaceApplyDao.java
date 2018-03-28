package com.ctg.flag.dao;

import com.ctg.flag.pojo.entity.SpaceApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceApplyDao extends JpaRepository<SpaceApply, Integer> {
    SpaceApply getByUid(Integer uid);

    Boolean existsByUidAndStateNot(Integer uid, Integer value);
}
