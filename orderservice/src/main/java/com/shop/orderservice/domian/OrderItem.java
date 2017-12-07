package com.shop.orderservice.domian;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 李浩
 * @date 2017/11/30
 */

public class OrderItem implements Serializable {
    private static final long serialVersionUID = 3854424464933186233L;
    private int id;
    private User user;
    private Orders orders;
    private Product product;
    private int number;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Orders getOrders() {
        return orders;
    }
    public void setOrders(Orders orders) {
        this.orders = orders;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }


}