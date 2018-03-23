package com.ctg.flag.web.controller;

import com.ctg.flag.dao.PlaceDao;
import com.ctg.flag.enums.PlaceKindEnum;
import com.ctg.flag.pojo.dto.ResponseDto;
import com.ctg.flag.pojo.entity.Place;
import com.ctg.flag.pojo.dto.PlaceDto;
import com.ctg.flag.pojo.entity.PlaceOrder;
import com.ctg.flag.service.PlaceOrderService;
import com.ctg.flag.service.PlaceService;
import com.ctg.flag.service.impl.PlaceOrderServiceImpl;
import com.ctg.flag.service.impl.PlaceServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class PlaceController {
    private PlaceOrderService placeOrderService;

    private PlaceService placeService;

    @RequestMapping(value = "/place",method = RequestMethod.GET)
    public ResponseDto placeList(){

        List<PlaceDto> pd = new ArrayList<>();

        /**
         * 正在被预约的事件
         */
        List<PlaceOrder> placeOrderList = placeOrderService.personOrderNum(2);

        /**
         * 所有场地列表
         */
        List<Place> placeList = placeService.browse();

        for(int i=0;i<placeList.size();++i){

            PlaceDto placeDto = new PlaceDto();
            placeDto.setName(placeList.get(i).getName());
            placeDto.setCount(placeList.get(i).getCount());

            int cnt = 0;  //记录一个场地正在被预约且未成功的事件的数量

            for(int j=0;j<placeOrderList.size();++j){

                if((int)placeList.get(i).getId() == (int)placeOrderList.get(j).getPid()){
                    cnt = cnt+1;
                }

            placeDto.setPersonOrderNum(new Integer(cnt));

            pd.add(placeDto);
            }
        }

        if (!pd.isEmpty()){
            return ResponseDto.succeed("ok",pd);
        }
        else
            return ResponseDto.failed("failed");

    }

}
