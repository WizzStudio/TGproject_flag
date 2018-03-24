package com.ctg.flag.dao;

import com.ctg.flag.pojo.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceDao extends JpaRepository<Place, Integer> {

<<<<<<< HEAD

    Place getPlaceByid(Integer id);
    Place findById(int id);
=======
    Place getPlaceById(Integer id);
>>>>>>> 2b81e649b084a37d5345166f28d6606d4e2c4a4b
}
