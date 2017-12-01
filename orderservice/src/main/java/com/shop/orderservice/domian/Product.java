package com.shop.orderservice.domian;

import javax.persistence.*;
import java.util.List;

/**
 * @author 李浩
 * @date 2017/11/30
 */
public class Product {
    private static final long serialVersionUID = 2497775039375521824L;
    private String uuid;
    private String name;
    private float originalPrice;
    private float promotePrice;
    private int stock;
    private String createTime;
    private Integer subdivideId;
    private String[] imagePath;
    /**
     *第一张图片路径
    */
    private String fristImagePath;

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

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public float getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(float promotePrice) {
        this.promotePrice = promotePrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getSubdivideId() {
        return subdivideId;
    }

    public void setSubdivideId(Integer subdivideId) {
        this.subdivideId = subdivideId;
    }

    public String[] getImagePath() {
        return imagePath;
    }

    public void setImagePath(String[] imagePath) {
        this.imagePath = imagePath;
    }

    public String getFristImagePath() {
        return fristImagePath;
    }

    public void setFristImagePath(String fristImagePath) {
        this.fristImagePath = fristImagePath;
    }
}
