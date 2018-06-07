package com.ctg.flag.dao;

import com.ctg.flag.dao.projection.CouncilOrderStatusProjection;
import com.ctg.flag.pojo.entity.CouncilOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouncilOrderDao extends JpaRepository<CouncilOrder, Integer> {
    CouncilOrder getById(Integer id);

    List<CouncilOrder> findAllByUid(Integer uid);

    List<CouncilOrderStatusProjection> getByUidOrderByStartTimeDesc(Integer userId);
}
