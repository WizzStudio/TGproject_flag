package com.ctg.flag.dao;

import com.ctg.flag.pojo.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceDao extends JpaRepository<Place, Integer> {

    Place getPlaceById(Integer id);
}
