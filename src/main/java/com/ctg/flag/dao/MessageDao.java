package com.ctg.flag.dao;

import com.ctg.flag.pojo.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao extends JpaRepository<Message, Integer> {

    Message getByKindAndState(Integer kind, Integer state);
}
