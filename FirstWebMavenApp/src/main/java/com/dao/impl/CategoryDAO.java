package com.dao.impl;

import java.util.Iterator;

import com.entity.Category;

public interface CategoryDAO {
	public Iterator<Category> allCategory();
	public void deleteCategory(int categoryId);
	void addCategory(Category c);
	void updateCategory(int categoryId, String name, String dis, String img);
}
