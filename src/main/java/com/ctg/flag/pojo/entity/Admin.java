package com.ctg.flag.pojo.entity;

import javax.persistence.Entity;

<<<<<<< HEAD
/**
 * 管理员领域对象
 */
=======
>>>>>>> 6caf28e6d417baa46593dd80449d4aec4a8bc4b4
@Entity
public class Admin {
    private Integer id;

    private String username;

    private String password;

    private Integer kind;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }
}
