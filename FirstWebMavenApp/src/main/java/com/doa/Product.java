package com.doa;

public class Product {
	int productId;
	int categoryId;
	String productName;
	float productPrice;
	int productQuantity;
	public Product() {}
	public Product(int productId, int categoryId, String productName, float productPrice, int productQuantity) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
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
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryId=" + categoryId + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + "]";
	}
	
	
}
