package com.cdac.dao;

import java.util.Iterator;

import com.cdac.tables.Category;

public interface CategoryDAO {
	public Iterator<Category> allCategory();
	public void deleteCategory(int categoryId);
	void addCategory(Category c);
	void updateCategory(int categoryId, String name, String dis, String img);
}
