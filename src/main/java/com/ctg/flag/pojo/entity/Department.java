package com.ctg.flag.pojo.entity;

import javax.persistence.Entity;

@Entity
public class Department {
    private Integer id; //部门id

    private String name;  //部门名称

    private String authcode; //部门身份认证码

    private Integer kind; //请求种类码

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode == null ? null : authcode.trim();
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }
}