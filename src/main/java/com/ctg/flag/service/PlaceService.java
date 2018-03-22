package com.ctg.flag.service;

import com.ctg.flag.pojo.entity.Place;

public interface PlaceService {

    Place getPlace(Integer id);

    void insert(Place place);

    void delete(Place place);

    void update(Place place);
}
