package com.ctg.flag.service.impl;

import com.ctg.flag.dao.PlaceDao;
import com.ctg.flag.pojo.entity.Place;
import com.ctg.flag.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.plugin.security.PluginClassLoader;

@Component
public class PlaceServiceImpl implements PlaceService {

    PlaceDao placeDao;

    @Autowired
    public PlaceServiceImpl(PlaceDao placeDao){ this.placeDao = placeDao; }

    @Override
    public Place getPlace(Integer id){
        Place place= placeDao.getPlaceByid(id);
        return place;
    }

    @Override
    public void insert(Place place){
        placeDao.save(place);
    }

    @Override
    public void update(Place place){
        placeDao.updateDescriptionById(place.getDescription(),place.getId());
    }
}
