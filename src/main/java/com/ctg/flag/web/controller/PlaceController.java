package com.ctg.flag.web.controller;

import com.ctg.flag.enums.PlaceOrderStateEnum;
import com.ctg.flag.pojo.dto.PlaceDetailDto;
import com.ctg.flag.pojo.dto.TimeSlotDto;
import com.ctg.flag.pojo.dto.ResponseDto;
import com.ctg.flag.util.DateUtil;
import com.ctg.flag.pojo.entity.Place;
import com.ctg.flag.pojo.dto.PlaceDto;
import com.ctg.flag.pojo.entity.PlaceOrder;
import com.ctg.flag.service.PlaceOrderService;
import com.ctg.flag.service.PlaceService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@RestController
public class PlaceController {
    private PlaceOrderService placeOrderService;

    private PlaceService placeService;

    @Autowired
    public PlaceController(PlaceOrderService placeOrderService,PlaceService placeService){
        this.placeOrderService = placeOrderService;
        this.placeService = placeService;
    }

    @RequestMapping(value = "/place",method = RequestMethod.GET)
    public ResponseDto placeList(){

        List<PlaceDto> pd = new ArrayList<>();

        //正在被预约的事件

        List<PlaceOrder> placeOrderList = placeOrderService.personOrderNum(2);

        //所有场地列表
        List<Place> placeList = placeService.browse();

        for(int i=0;i<placeList.size();++i){

            PlaceDto placeDto = new PlaceDto(placeList.get(i).getId(),placeList.get(i).getName(),placeList.get(i).getCount());
            int cnt = 0;  //记录一个场地正在被预约且未成功的事件的数量

            for(int j=0;j<placeOrderList.size();++j){

                if((int)placeList.get(i).getId() == (int)placeOrderList.get(j).getPid()){
                    cnt = cnt+1;
                }

            placeDto.setPersonOrderNum(cnt);

            pd.add(placeDto);
            }
        }

        if (!pd.isEmpty()){
            return ResponseDto.succeed("ok",pd);
        }
        else
            return ResponseDto.failed("failed");

    }

    @RequestMapping(value = "/place/{id}/{date}",method = RequestMethod.GET)
    public ResponseDto placeDetail(@PathVariable("id") int id,@PathVariable("date") String date){

        Place place = placeService.getPlace(id);


        //正在被预约的场地列表
        List<PlaceOrder> placeOrderList = placeOrderService.personOrderNum(PlaceOrderStateEnum.ACCEPTED.getValue());
        //ID为id的场地成功预约的列表
        List<PlaceOrder> idPlaceOrder = placeOrderService.successOrderNum(id, PlaceOrderStateEnum.ACCEPTED.getValue());

        PlaceDetailDto placeDetailDto = new PlaceDetailDto(place.getDescription());

        //使 正在被预约的场地列表 全部是id场地
        for (int i=0;i<placeOrderList.size();++i){
            if(placeOrderList.get(i).getId().intValue()!=id){
                placeOrderList.remove(i);
            }

        }

        Date date1 = DateUtil.String2Date(date);//将string类型转换为date类型

        for(int i=0;i<placeOrderList.size();++i) {
            //在ID为id正在被预约列表中找到日期为date的预约事件
            if (DateUtil.isSameDay(date1, placeOrderList.get(i).getStartTime())) {
                Date startTime = placeOrderList.get(i).getStartTime();
                Date endTime = placeOrderList.get(i).getEndTime();

                TimeSlotDto timeSlotDto = new TimeSlotDto(startTime, endTime);
                //加入placeDetailDto
                placeDetailDto.getTiming().add(timeSlotDto);
            }
        }

        for(int i=0;i<idPlaceOrder.size();++i){
            //在ID为id的场地成功预约列表中找到日期为date的预约事件
            if(DateUtil.isSameDay(date1,idPlaceOrder.get(i).getStartTime())){
                Date startTime = idPlaceOrder.get(i).getStartTime();
                Date endTime = idPlaceOrder.get(i).getEndTime();

                TimeSlotDto timeSlotDto = new TimeSlotDto(startTime,endTime);
                //加入placeDetailDto
                placeDetailDto.getSuccessTime().add(timeSlotDto);

            }

        }
        if(placeDetailDto.getSuccessTime().size()==0 && placeDetailDto.getTiming().size() !=0){
            return ResponseDto.succeed("该场地无人正在预约",placeDetailDto);
        }
        else if(placeDetailDto.getSuccessTime().size()!=0 && placeDetailDto.getTiming().size() ==0){
            return ResponseDto.succeed("该场地无人已预约",placeDetailDto);
        }
        else if(placeDetailDto.getSuccessTime().size()==0 && placeDetailDto.getTiming().size() ==0){
            return ResponseDto.succeed("该场地空闲无人预约或准备预约",placeDetailDto);
        }

        return ResponseDto.succeed("ok",placeDetailDto);



    }

}
