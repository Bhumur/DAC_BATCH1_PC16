package com.cdac.CategoryRestAPI.dto;

public class CategoryDto {
	int categoryid;
	String categoryname;
	String categorydiscription;
	String categoryimg;
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getCategorydiscription() {
		return categorydiscription;
	}
	public void setCategorydiscription(String categorydiscription) {
		this.categorydiscription = categorydiscription;
	}
	@Override
	public String toString() {
		return "CategoryDto [categoryid=" + categoryid + ", categoryname=" + categoryname + ", categorydiscription="
				+ categorydiscription + ", categoryimg=" + categoryimg + "]";
	}
	public String getCategoryimg() {
		return categoryimg;
	}
	public void setCategoryimg(String categoryimg) {
		this.categoryimg = categoryimg;
	}
	
}
