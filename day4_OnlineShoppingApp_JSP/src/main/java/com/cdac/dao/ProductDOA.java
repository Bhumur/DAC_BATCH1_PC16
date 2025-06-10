package com.cdac.dao;

import java.util.Iterator;

import com.cdac.tables.Product;

public interface ProductDOA {
	public Iterator<Product> showProduct(int categoryId);
	void addProduct(Product p);
	void deleteProduct(int categoryId, int productId);
	void updateProduct(int categoryId, int productId, String name, float price, int qty);
}
