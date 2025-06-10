package com.cdac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.cdac.tables.Cart;

public class CartDAOImp implements CartDAO {
	Connection dbConnection;
	
	public CartDAOImp(Connection db) {
		this.dbConnection = db;
		System.out.println(db);
	}
	
	@Override
	public Iterator<Cart> showCart(String username) {
		try {
			PreparedStatement ps = dbConnection.prepareStatement("select * from cart where username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			ArrayList<Cart> list = new ArrayList<>();
			while(rs.next()) {
				Cart obj = new Cart(
						rs.getString("username"),
						rs.getString("productName"),
						rs.getInt("categoryId"),
						rs.getInt("productId"),
						rs.getInt("quantity"),
						rs.getFloat("price")
						);
				list.add(obj);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void addToCart(String u, int cid, int pid, float price, String name) {
		PreparedStatement ps;
		try {
			ps = dbConnection.prepareStatement("Select * from cart where username=? and categoryId=? and productId=?");
			ps.setString(1, u);
			ps.setInt(2, cid);
			ps.setInt(3, pid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int qty = rs.getInt("quantity");
				ps=dbConnection.prepareStatement("update cart set quantity = ? where username=? and categoryId=? and productId=?");
				ps.setInt(1,qty+1);
				ps.setString(2, u);
				ps.setInt(3, cid);
				ps.setInt(4, pid);
				ps.executeUpdate();
			}else {
				ps=dbConnection.prepareStatement("insert into cart values(?,?,?,?,?,?)");
				ps.setString(1, u);
				ps.setInt(2, cid);
				ps.setInt(3, pid);
				ps.setInt(4,1);
				ps.setFloat(5, price);
				ps.setString(6, name);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void emptyCart(String username) {
		try {
			PreparedStatement ps = dbConnection.prepareStatement("delete from cart where username = ?");
			ps.setString(1, username);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteItem(String u, int cid, int pid) {
		PreparedStatement ps;
		try {
			ps = dbConnection.prepareStatement("Select * from cart where username=? and categoryId=? and productId=?");
			ps.setString(1, u);
			ps.setInt(2, cid);
			ps.setInt(3, pid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int qty = rs.getInt("quantity");
				if(qty==1) {
					ps=dbConnection.prepareStatement("delete from cart where username=? and categoryId=? and productId=?");
					ps.setString(1, u);
					ps.setInt(2, cid);
					ps.setInt(3, pid);
					ps.executeUpdate();
				}else {
					ps=dbConnection.prepareStatement("update cart set quantity = ? where username=? and categoryId=? and productId=?");
					ps.setInt(1,qty-1);
					ps.setString(2, u);
					ps.setInt(3, cid);
					ps.setInt(4, pid);
					ps.executeUpdate();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeFromCart(String username, int cId, int pId) {
		// TODO Auto-generated method stub
		
	}

}
