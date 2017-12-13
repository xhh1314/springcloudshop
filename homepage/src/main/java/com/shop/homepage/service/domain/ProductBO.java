package com.shop.homepage.service.domain;

import com.shop.homepage.bean.Product;
import com.shop.homepage.bean.ProductImage;
import com.shop.homepage.bean.Subdivide;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 李浩
 * @date 2017/12/7
 */
public class ProductBO {
    private static final long serialVersionUID = 2497775039375521824L;
    private String uuid;
    private String name;
    private float originalPrice;
    private float promotePrice;
    private Integer stock;
    private String createTime;
    //第一张图片的存储路径
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFristImagePath() {
        return fristImagePath;
    }

    public void setFristImagePath(String fristImagePath) {
        this.fristImagePath = fristImagePath;
    }

    public ProductBO(Product product) {
        this.uuid = product.getUuid();
        this.createTime = product.getCreateTime();
        List<ProductImage> images;
        if ((images = product.getProductImage()) != null && !images.isEmpty()) {
            this.fristImagePath = images.get(0).getValue();
        }
        this.name = product.getName();
        this.originalPrice = product.getOriginalPrice();
        this.promotePrice = product.getPromotePrice();
        this.stock = product.getStock();

    }

    public ProductBO() {
    }

    /**
     * 转换集合product
     *
     * @param
     * @return
     * @author 李浩
     * @date 2017/12/7
     * @version
     */
    public static List<ProductBO> transferFromProductDO(List<Product> products) {
        List<ProductBO> productBOS = new ArrayList<ProductBO>(32);
        for (Product e : products) {
            productBOS.add(new ProductBO(e));
        }
        return productBOS;

    }



}
