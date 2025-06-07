package com.cdac.dao;

import java.util.Iterator;

import com.cdac.tables.Product;

public interface ProductDOA {
	public Iterator<Product> showProduct(int categoryId);
	public void deleteUser(int categoryId, int productId);
	void addProduct(Product p);
	void updateUser(int categoryId, int productId, String name, float price, int qty);
}
