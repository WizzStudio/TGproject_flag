package com.ctg.flag.service;

import com.ctg.flag.pojo.dto.OptionDto;
import com.ctg.flag.pojo.entity.Place;

import java.util.List;

public interface PlaceService {

    Place getPlace(int id);

    void insert(Place place);

    void delete(Place place);

    void update(Place place);

    void setCount(Place place);

    List<Place> browse();

    /**
     * 获取所有会务室信息
     */
    List<OptionDto<String, Integer>> listAllCouncil();
}
