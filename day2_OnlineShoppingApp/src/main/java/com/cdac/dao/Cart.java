package com.cdac.dao;

public class Cart {
	String username;
	int categoryId;
	int productId;
	int quantity;
	public Cart() {}
	public Cart(String username, int categoryId, int productId, int quantity) {
		super();
		this.username = username;
		this.categoryId = categoryId;
		this.productId = productId;
		this.quantity = quantity;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [username=" + username + ", categoryId=" + categoryId + ", productId=" + productId + ", quantity="
				+ quantity + "]";
	}
	
	
}
