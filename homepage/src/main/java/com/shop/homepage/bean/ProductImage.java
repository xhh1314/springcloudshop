package com.shop.homepage.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Entity
@Component
@Scope("prototype")
public class ProductImage implements Serializable{
	
	private static final long serialVersionUID = 4163122448247304244L;
	private int id;
	private String value;
	//private String pd_uuid;
	private Product product;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="type")
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@ManyToOne
	@JoinColumn(name="pd_uuid",referencedColumnName="uuid")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
