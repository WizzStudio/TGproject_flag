package com.ctg.flag.service.impl;

import com.ctg.flag.dao.PlaceDao;
import com.ctg.flag.pojo.entity.Place;
import com.ctg.flag.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlaceServiceImpl implements PlaceService {

    private PlaceDao placeDao;

    @Autowired
    public PlaceServiceImpl(PlaceDao placeDao){ this.placeDao = placeDao; }

    @Override
    public Place getPlace(int id){
        return placeDao.findById(id);
    }

    @Override
    public void insert(Place place){
        placeDao.save(place);
    }

    @Override
    public void update(Place place){

        Place p = placeDao.findById((int)place.getId());

        p.setDescription(place.getDescription());
        p.setAid(place.getAid());
        p.setKind(place.getKind());
        p.setName(place.getName());

        placeDao.save(p);
    }

    @Override
    public void delete(Place place){
        Place p = placeDao.findById((int)place.getId());
        placeDao.delete(p);
    }

    @Override
    public void setCount(Place place){
        Place p = placeDao.findById((int)place.getId());
        p.setCount(p.getId()+(Integer)1);
        placeDao.save(p);
    }

    @Override
    public List<Place> browse(){
        return placeDao.findAll();
    }
}
