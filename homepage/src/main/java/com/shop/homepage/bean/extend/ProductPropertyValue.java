package com.shop.homepage.bean.extend;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**该类用来封装前端传送过来的json数组数据
 * @author lh
 *
 */
@Entity
public class ProductPropertyValue {
	private Double pvid;
	private String productUuid;
	private String productName;
	private String propertyName;
	private String propertyValue;
	
	@Id//这个id是在联查的时候增加的，联查必须增加一列Id与之对应，如果id指定为其他非唯一标识的字段，则list集合数据会出现重复情况
	public Double getPvid() {
		return pvid;
	}
	public void setPvid(Double pvid) {
		this.pvid = pvid;
	}
	
	public String getProductUuid() {
		return productUuid;
	}
	
	public String getProductName() {
		return productName;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setProductUuid(String productUuid) {
		this.productUuid = productUuid;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	
	
	

}
