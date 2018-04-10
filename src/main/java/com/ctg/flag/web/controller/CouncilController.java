package com.ctg.flag.web.controller;

import com.ctg.flag.pojo.dto.OptionDto;
import com.ctg.flag.pojo.dto.ResponseDto;
import com.ctg.flag.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/council")
public class CouncilController {
    private PlaceService placeService;

    @Autowired
    public CouncilController(PlaceService placeService) {
        this.placeService = placeService;
    }

    /**
     * 获得所有会务室名称和id
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseDto getCouncilList() {
        List<OptionDto<String, Integer>> councils = placeService.listAllCouncil();

        return ResponseDto.succeed(null, councils);
    }
}
