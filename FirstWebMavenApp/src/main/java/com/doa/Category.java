package com.doa;

public class Category {
	int categoryId;
	String categoryName;
	String categoryDiscription;
	String categoryImg;
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
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDiscription="
				+ categoryDiscription + ", categoryImg=" + categoryImg + "]";
	}
	
	
}
