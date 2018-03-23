package com.ctg.flag.pojo.dto;

import java.util.Date;

public class OrderManageDto {
    private Date createTime;
    private String placeName;

    public OrderManageDto() {}

    public OrderManageDto(Date createTime, String placeName) {
        this.createTime = createTime;
        this.placeName = placeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
