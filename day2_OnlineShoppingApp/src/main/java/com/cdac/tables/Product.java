package com.cdac.tables;

public class Product {
	int productId;
	int categoryId;
	String productName;
	float productPrice;
	int productQuantity;
	public Product() {}
	public Product(int productId, int categoryId, String categoryName, float categoryPrice, int categoryQuantity) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = categoryName;
		this.productPrice = categoryPrice;
		this.productQuantity = categoryQuantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String categoryName) {
		this.productName = categoryName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float categoryPrice) {
		this.productPrice = categoryPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int categoryQuantity) {
		this.productQuantity = categoryQuantity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryId=" + categoryId + ", categoryName=" + productName
				+ ", categoryPrice=" + productPrice + ", categoryQuantity=" + productQuantity + "]";
	}
	
}
