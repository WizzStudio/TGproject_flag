package com.ctg.flag.dao;

import com.ctg.flag.pojo.entity.Place;
import com.ctg.flag.pojo.entity.PlaceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceOrderDao extends JpaRepository<PlaceOrder, Integer> {
    List<PlaceOrder> findAllByUidAndStateNot(Integer id, Integer state);
<<<<<<< HEAD

    /**
     *
     * 寻找状态码小于num的预约事件
     * 为了找到一个场地正在预约的人数，状态码为0和1
     */
    List<PlaceOrder> findAllByStateLessThan(int num);
=======
<<<<<<< HEAD

    /**
     * 根据id查询场地
     * @param id
     * @return
     */
=======
>>>>>>> c7fc44bee253bb856cbcf90b6339606dcf3d5d5b
    PlaceOrder getById(Integer id);
>>>>>>> d35ee7820f1ad71ef7f521d8802173d0ddecd7c3
}
