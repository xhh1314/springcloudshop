package com.shop.orderservice.domian;

import java.util.List;

/**
 * @author 李浩
 * @date 2017/11/30
 */
public class User {
    private static final long serialVersionUID = 2635050830373241097L;
    private String uuid;
    private String name;
    private String email;
    private List<Orders> orders;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
