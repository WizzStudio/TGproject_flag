package com.ctg.flag.dao;

import com.ctg.flag.pojo.entity.Place;
import com.ctg.flag.pojo.entity.PlaceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceOrderDao extends JpaRepository<PlaceOrder, Integer> {
    List<PlaceOrder> findAllByUidAndStateNot(Integer id, Integer state);

    /**
     *
     * 寻找状态码小于num的预约事件
     * 为了找到一个场地正在预约的人数，状态码为0和1
     */
    List<PlaceOrder> findAllByStateLessThan(int num);

    /**
     *
     * 根据id和状态码查询事件
     */
    List<PlaceOrder> findAllByIdAndState(int id,int state);

    /**
     * 根据id查询场地
     */
    PlaceOrder getPlaceOrderById(Integer pid);

    PlaceOrder getPlaceOrderByIdAndStateNot(Integer oid, Integer status);


}
