package com.dao.impl;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.entity.Category;
import com.entity.Product;


public class ProductDAOImp implements ProductDOA {
	Session session = null;
	public ProductDAOImp(SessionFactory sec) {
		super();
		session = sec.openSession();
	}

	@Override
	public void addProduct(Product p) {
		
			
	}

	@Override
	public Iterator<Product> showProduct(int categoryId) {
		//Query<Product> query = session.createQuery("FROM Product WHERE categoryId = :cid", Product.class);

		//Query<Product> query = session.createNativeQuery("SELECT * FROM product WHERE categoryId = :cid", Product.class);
		Category cat = session.find(Category.class, categoryId);
		return cat.getProducts().iterator();
	}

	@Override
	public void deleteProduct(int categoryId, int productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProduct(int categoryId, int productId, String name, float price, int qty) {
		
	}

}
