package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CartId {
	@Column(name="username")
	String username;
	@Column(name="categoryId")
	int categoryId;
	@Column(name="productId")
	int productId;
	public CartId() {}
	public CartId(String username, int categoryId, int productId) {
		super();
		this.username = username;
		this.categoryId = categoryId;
		this.productId = productId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
}
