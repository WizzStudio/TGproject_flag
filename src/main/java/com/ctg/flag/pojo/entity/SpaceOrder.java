package com.ctg.flag.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "space_order", schema = "flag")
public class SpaceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer uid;
    private Integer aid;
    private Date createTime = new Date();
    private Date updateTime = new Date();
}
