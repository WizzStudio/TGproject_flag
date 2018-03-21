package com.ctg.flag.enums;

public enum PlaceOrderStateEnum {
    /**
     * 提交申请
     */
    PENDING(0),

    /**
     * 二级管理员通过
     */
    SECOND_ACCEPTED(1),


    /**
     * 一级管理员通过
     */
    ACCEPTED(2),

    /**
     * 未通过
     */
    REFUSED(3);

    private Integer value;

    PlaceOrderStateEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
