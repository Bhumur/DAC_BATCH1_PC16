package com.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@Column(name="categoryId")
	int categoryId;
	@Column(name="categoryName")
	String categoryName;
	@Column(name="categoryDiscription")
	String categoryDiscription;
	@Column(name="categoryImg")
	String categoryImg;
	
	@OneToMany(mappedBy = "category")
	Set<Product> products;
	public Category() {}
	public Category(int categoryId, String categoryName, String categoryDiscription, String categoryImg) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDiscription = categoryDiscription;
		this.categoryImg = categoryImg;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDiscription() {
		return categoryDiscription;
	}
	public void setCategoryDiscription(String categoryDiscription) {
		this.categoryDiscription = categoryDiscription;
	}
	public String getCategoryImg() {
		return categoryImg;
	}
	public void setCategoryImg(String categoryImg) {
		this.categoryImg = categoryImg;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDiscription="
				+ categoryDiscription + ", categoryImg=" + categoryImg + ", products=" + products + "]";
	}
	
}

