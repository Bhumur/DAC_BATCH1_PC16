package com.cdac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.cdac.tables.Product;

public class ProductDAOImp implements ProductDOA {
	Connection dbConnection ;
	public ProductDAOImp(Connection dbConnection) {
		super();
		this.dbConnection = dbConnection;
	}

	@Override
	public void addProduct(Product p) {
		
			PreparedStatement psAddProduct;
			try {
				System.out.println(p.toString());
				psAddProduct = dbConnection.prepareStatement("Insert into product values(?,?,?,?,?)");
				psAddProduct.setInt(1, p.getCategoryId());
				psAddProduct.setInt(2, p.getProductId());
				psAddProduct.setString(3, p.getProductName());
				psAddProduct.setFloat(4, p.getProductPrice());
				psAddProduct.setInt(5, p.getProductQuantity());
				psAddProduct.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public Iterator<Product> showProduct(int categoryId) {
		try {
			PreparedStatement psShowProduct = dbConnection.prepareStatement("Select * from product where categoryId=?");
			psShowProduct.setInt(1, categoryId);
			ResultSet resultShowProduct = psShowProduct.executeQuery();
			ArrayList<Product> list = new ArrayList<>();
			while(resultShowProduct.next()) {
				list.add(new Product(
						resultShowProduct.getInt(1),
						resultShowProduct.getInt(2),
						resultShowProduct.getString(3),
						resultShowProduct.getFloat(4),
						resultShowProduct.getInt(5)
						));
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteUser(int categoryId, int productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(int categoryId, int productId, String name, float price, int qty) {
		try {
			PreparedStatement psUpdateProduct = dbConnection.prepareStatement("update product set productName=?, productPrice=?, productQuantity=? where productId=? and categoryId=?;");
			
			psUpdateProduct.setString(1, name);
			psUpdateProduct.setFloat(2, price);
			psUpdateProduct.setInt(3, qty);
			psUpdateProduct.setInt(4, productId);
			psUpdateProduct.setInt(5, categoryId);
			psUpdateProduct.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
