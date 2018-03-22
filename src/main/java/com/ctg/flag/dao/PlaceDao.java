package com.ctg.flag.dao;

import com.ctg.flag.pojo.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PlaceDao extends JpaRepository<Place, Integer> {

    Place getPlaceByid(Tnteger id);

    @Transactional
    @Modifying
    @Query(value = "update place a set a.description = ?1 where a.id = ?2",nativeQuery = true)
    int updateDescriptionById(String description,Integer id);
}
