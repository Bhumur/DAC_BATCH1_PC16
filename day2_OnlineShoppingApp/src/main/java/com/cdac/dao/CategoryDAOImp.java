package com.cdac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.cdac.tables.Category;


public class CategoryDAOImp implements CategoryDAO {
	Connection dbConnection ;
	public CategoryDAOImp(Connection dbConnection) {
		super();
		this.dbConnection = dbConnection;
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
