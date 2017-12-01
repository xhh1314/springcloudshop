package com.shop.orderservice.domian;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 李浩
 * @date 2017/11/30
 */
@Component
@Scope("prototype")
@Entity
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 3854424464933186233L;
    private int id;
    private User user;
    private Orders orders;
    private Product product;
    private int number;
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name="u_uuid",referencedColumnName="uuid")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne
    @JoinColumn(name="o_uuid",referencedColumnName="uuid")
    public Orders getOrders() {
        return orders;
    }
    public void setOrders(Orders orders) {
        this.orders = orders;
    }
    @ManyToOne
    @JoinColumn(name="pd_uuid",referencedColumnName="uuid")
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