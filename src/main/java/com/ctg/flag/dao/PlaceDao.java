package com.ctg.flag.dao;

import com.ctg.flag.pojo.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceDao extends JpaRepository<Place, Integer> {


    Place getPlaceByid(Integer id);
=======
    Place findById(int id);
>>>>>>> 5b5b3b4e4372d9e47484f01f8a7bf67a87f10db8

}
