package com.shop.orderservice.domian;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 李浩
 * @date 2017/11/30
 */

@Entity
@Component
@Scope("prototype")
public class Orders implements Serializable {
    private static final long serialVersionUID = 4025200169942039793L;
    private String uuid;
    private String ordercode;
    private String address;
    private String postCode;
    private String receiver;
    private String mobile;
    private String userMessage;
    private Date createDate;
    private Date payDate;
    private Date deliveryDate;
    private Date cofirmDate;
    private String status;
    private User user;

    @Id
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name="post")
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    @Column
    @Temporal(value = TemporalType.DATE)
    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * @return
     */
    @Column
    @Temporal(value = TemporalType.DATE)
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * 格式：2017-11-29
     * @return
     */
    @Column(name="confirmDate")
    @Temporal(value = TemporalType.DATE)
    public Date getCofirmDate() {
        return cofirmDate;
    }

    /**
     * @param cofirmDate
     * @author
     */
    public void setCofirmDate(Date cofirmDate) {
        this.cofirmDate = cofirmDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "u_uuid", referencedColumnName = "uuid")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     *  格式：2015-12-29 16:54:04.544
     * @return
     */
    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}