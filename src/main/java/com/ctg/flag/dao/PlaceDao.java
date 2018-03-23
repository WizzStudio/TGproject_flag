package com.ctg.flag.dao;

import com.ctg.flag.pojo.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceDao extends JpaRepository<Place, Integer> {

<<<<<<< HEAD
    Place findById(int id);

=======
<<<<<<< HEAD

    Place getPlaceByid(Integer id);
=======
=======
>>>>>>> c7fc44bee253bb856cbcf90b6339606dcf3d5d5b
    Place findById(int id);
>>>>>>> d35ee7820f1ad71ef7f521d8802173d0ddecd7c3
}
