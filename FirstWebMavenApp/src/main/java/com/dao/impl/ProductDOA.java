package com.dao.impl;

import java.util.Iterator;

import com.entity.Product;


public interface ProductDOA {
	public Iterator<Product> showProduct(int categoryId);
	void addProduct(Product p);
	void deleteProduct(int categoryId, int productId);
	void updateProduct(int categoryId, int productId, String name, float price, int qty);
}
