package com.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ProductId implements Serializable {
	@Column(name="categoryId")
	int categoryId;
	@Column(name="productId")
	int productId;
	public ProductId() {}
	public ProductId(int categoryId, int productId) {
		super();
		this.categoryId = categoryId;
		this.productId = productId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "ProductId [categoryId=" + categoryId + ", productId=" + productId + "]";
	}
	
}

