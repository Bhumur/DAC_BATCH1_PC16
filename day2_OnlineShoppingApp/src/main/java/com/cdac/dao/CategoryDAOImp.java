package com.cdac.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import com.cdac.tables.Category;


public class CategoryDAOImp implements CategoryDAO {
	Properties dbProperties;
	Connection dbConnection ;
	String URL;
	String schema;
	String user;
	String pass;
	public CategoryDAOImp() {
		super();
		try {
			InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties");
			Properties dbProperties = new Properties();
			dbProperties.load(input);
			System.out.println(dbProperties);
			URL = dbProperties.getProperty("connection.url");
			schema = dbProperties.getProperty("connection.schema");
			user = dbProperties.getProperty("connection.user");
			pass = dbProperties.getProperty("connection.pass");
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.dbConnection = DriverManager.getConnection(URL+schema,user,pass);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addCategory(Category c ) {			
			PreparedStatement psAddCategory;
			try {
				psAddCategory = dbConnection.prepareStatement("Insert into category values(?,?,?,?)");
				psAddCategory.setInt(1, c.getCategoryId());
				psAddCategory.setString(2, c.getCategoryName());
				psAddCategory.setString(3, c.getCategoryDiscription());
				psAddCategory.setString(4, c.getCategoryImg());
				psAddCategory.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public Iterator<Category> allCategory() {
		try {
			PreparedStatement psShowCategory = dbConnection.prepareStatement("Select * from category");
			ResultSet resultShowCategory = psShowCategory.executeQuery();
			ArrayList<Category> list = new ArrayList<>();
			while(resultShowCategory.next()) {
				list.add(new Category(
						resultShowCategory.getInt(1),
						resultShowCategory.getString(2),
						resultShowCategory.getString(3),
						resultShowCategory.getString(4)
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
	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCategory(int categoryId, String name, String dis, String img) {
		try {
			PreparedStatement psUpdateCategory = dbConnection.prepareStatement("update category set categoryName=?, categoryDiscription=?, categoryImg=? where categoryId=?;");
			psUpdateCategory.setString(1,name);
			psUpdateCategory.setString(2,dis);
			psUpdateCategory.setString(3,img);
			psUpdateCategory.setInt(4,categoryId);
			psUpdateCategory.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
