package com.cdac.CategoryRestAPI.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class CategoryEntity {
	@Id
	@Column(name="categoryid")
	int categoryid;
	@Column(name="categoryname")
	String categoryname;
	@Column(name="categorydiscription")
	String categorydiscription;
	@Column(name="categoryimg")
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
	public String getCategoryimg() {
		return categoryimg;
	}
	public void setCategoryimg(String categoryimg) {
		this.categoryimg = categoryimg;
	}
	@Override
	public String toString() {
		return "CategoryEntity [categoryid=" + categoryid + ", categoryname=" + categoryname + ", categorydiscription="
				+ categorydiscription + ", categoryimg=" + categoryimg + "]";
	}
	
}
