package com.ctg.flag.pojo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

<<<<<<< HEAD

/**
 * 管理员领域对象
 */

=======
>>>>>>> 5b5b3b4e4372d9e47484f01f8a7bf67a87f10db8
@Entity
@Table(name = "admin", schema = "flag")
public class Admin {
    @Id
    @GeneratedValue
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
