package com.shop.userservice.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * @author 李浩
 * @date 2017/11/29
 */
@Component
@Scope("prototype")
@Entity(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 2635050830373241097L;
    private String uuid;
    private String name;
    private String password;
    private String email;
    @Id
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }



}
