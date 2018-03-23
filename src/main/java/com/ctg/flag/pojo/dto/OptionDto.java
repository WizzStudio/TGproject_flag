package com.ctg.flag.pojo.dto;

public class OptionDto <A, B> {
    private A optKey;
    private B optVal;

    public void setOptKey(A optKey) {
        this.optKey = optKey;
    }

    public void setOptVal(B optVal) {
        this.optVal = optVal;
    }

    public A getOptKey() {
        return optKey;
    }

    public B getOptVal() {
        return optVal;
    }
}
