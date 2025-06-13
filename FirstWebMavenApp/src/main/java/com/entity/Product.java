package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@EmbeddedId
	ProductId productid;
	
	@Column(name="productsName")
	String productsName;
	
	@Column(name="productsPrice")
	float productsPrice;
	
	@Column(name="productsQuantity")
	int productQuantity;
	
	public Product() {}

	public Product(ProductId productid, String productsName, float productsPrice, int productQuantity) {
		super();
		this.productid = productid;
		this.productsName = productsName;
		this.productsPrice = productsPrice;
		this.productQuantity = productQuantity;
	}

	public ProductId getProductid() {
		return productid;
	}

	public void setProductid(ProductId productid) {
		this.productid = productid;
	}

	public String getProductsName() {
		return productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}

	public float getProductsPrice() {
		return productsPrice;
	}

	public void setProductsPrice(float productsPrice) {
		this.productsPrice = productsPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productsName=" + productsName + ", productsPrice=" + productsPrice
				+ ", productQuantity=" + productQuantity + "]";
	}
	
}
