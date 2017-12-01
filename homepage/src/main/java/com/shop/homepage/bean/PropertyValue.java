package com.shop.homepage.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
public class PropertyValue implements Serializable{
	private static final long serialVersionUID = 3527677684670642996L;
	private int id;
	private String value;
	private String pd_uuid;
	private String pp_uuid;
	//private Property property;
	//private Product product;
	//使用JSON数据格式时，应该申明一个默认构造器
	public PropertyValue() {
		
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getPd_uuid() {
		return pd_uuid;
	}
	public void setPd_uuid(String pd_uuid) {
		this.pd_uuid = pd_uuid;
	}
	public String getPp_uuid() {
		return pp_uuid;
	}
	public void setPp_uuid(String pp_uuid) {
		this.pp_uuid = pp_uuid;
	}
	

}
