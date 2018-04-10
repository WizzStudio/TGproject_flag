package com.ctg.flag.pojo.dto;

import java.util.Date;

public class CouncilOrderListDto {
    private Integer id;
    private String councilName;
    private Date createTime;
    private Integer state;

    public CouncilOrderListDto(Integer id, String councilName, Date createTime, Integer state) {
        this.id = id;
        this.councilName = councilName;
        this.createTime = createTime;
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }
}
