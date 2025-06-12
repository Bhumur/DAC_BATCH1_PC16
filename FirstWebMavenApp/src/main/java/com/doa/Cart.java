package com.doa;

public class Cart {
	String username;
	String name;
	int categoryId;
	int productId;
	int quantity;
	float price;
	public Cart() {}
	public Cart(String username, String name, int categoryId, int productId, int quantity, float price) {
		super();
		this.username = username;
		this.name = name;
		this.categoryId = categoryId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Cart [username=" + username + ", name=" + name + ", categoryId=" + categoryId + ", productId="
				+ productId + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
}
