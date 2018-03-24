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
     * 根据id查询场地
     * @param id
     * @return
     */
    PlaceOrder getById(Integer id);
}
