package com.ctg.flag.service.impl;

import com.ctg.flag.dao.PlaceDao;
import com.ctg.flag.enums.PlaceKindEnum;
import com.ctg.flag.pojo.dto.OptionDto;
import com.ctg.flag.pojo.entity.Place;
import com.ctg.flag.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaceServiceImpl implements PlaceService {

    private PlaceDao placeDao;

    @Autowired
    public PlaceServiceImpl(PlaceDao placeDao){ this.placeDao = placeDao; }

    @Override
    public Place getPlace(int id){
        return placeDao.getPlaceById(id);
    }

    @Override
    public void insert(Place place){
        placeDao.save(place);
    }

    @Override
    public void update(Place place){

        Place p = placeDao.getPlaceById((int)place.getId());

        p.setDescription(place.getDescription());
        // p.setAdminKind(place.getAdminKind());
        p.setKind(place.getKind());
        p.setName(place.getName());

        placeDao.save(p);
    }

    @Override
    public void delete(Place place){
        Place p = placeDao.getPlaceById((int)place.getId());
        placeDao.delete(p);
    }

    @Override
    public void setCount(Place place){
        Place p = placeDao.getPlaceById((int)place.getId());
        p.setCount(p.getId()+(Integer)1);
        placeDao.save(p);
    }

    @Override
    public List<Place> browse(){
        return placeDao.findAllByKind(PlaceKindEnum.ORDINARY_ROOM.getValue());
    }

    @Override
    public List<OptionDto<String, Integer>> listAllCouncil() {
        List<Place> councils = placeDao.findAllByKind(PlaceKindEnum.CONFERENCE_ROOM.getValue());

        System.out.println(councils.size());

        List<OptionDto<String, Integer>> cl = new ArrayList<>();
        councils.forEach(c -> {
            cl.add(new OptionDto<>(c.getName(), c.getId()));
        });
        return cl;
    }
}
