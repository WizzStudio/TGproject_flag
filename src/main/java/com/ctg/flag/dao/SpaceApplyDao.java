package com.ctg.flag.dao;

import com.ctg.flag.pojo.entity.SpaceApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface SpaceApplyDao extends JpaRepository<SpaceApply, Integer> {

    Boolean existsByUidAndStateIn(Integer uid, Collection<Integer> state);

    List<SpaceApply> getByUidAndStateIn(Integer uid, List<Integer> states);
}
