package com.shop.orderservice.domian;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 李浩
 * @date 2017/12/4
 */
@Entity(name = "orderitem")
public class OrderItemDO {

    private Integer id;
    private String productUuid;
    private String orderUuid;
    private String userUuid;
    private Integer number;

    public OrderItemDO(){}
    public OrderItemDO(OrderItem orderItem){
        this.id=orderItem.getId();
        this.productUuid=orderItem.getProduct().getUuid();
        this.orderUuid =orderItem.getOrders().getUuid();
        this.userUuid =orderItem.getUser().getUuid();
        this.number=orderItem.getNumber();
    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "pd_uuid")
    public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

    @Column(name = "o_uuid")
    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }

    @Column(name = "u_uuid")
    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
