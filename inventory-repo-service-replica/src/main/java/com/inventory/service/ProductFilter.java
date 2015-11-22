package com.inventory.service;

import java.util.List;

public class ProductFilter {
	private Integer supplerId;
	private Integer businessGroupId;
	private Integer categoryId;
	private Integer brandId;
	private String productName;
	
	public Integer getSupplerId() {
		return supplerId;
	}
	public void setSupplerId(Integer supplerId) {
		this.supplerId = supplerId;
	}
	public Integer getBusinessGroupId() {
		return businessGroupId;
	}
	public void setBusinessGroupId(Integer businessGroupId) {
		this.businessGroupId = businessGroupId;
	}
	
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
}
