package com.cdac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.cdac.tables.User;

public class UserDAOImp implements UserDAO {
	Connection dbConnection = null;
	
	public UserDAOImp(Connection dbConnection) {
		super();
		this.dbConnection = dbConnection;
	}

	@Override
	public void addUser(User u) {
		try(Scanner sc = new Scanner(System.in)){
			PreparedStatement psAddUser = dbConnection.prepareStatement("Insert into users values(?,?,?,?,?)");
			psAddUser.setString(1, u.getUsername());
			psAddUser.setString(2, u.getPassword());
			psAddUser.setString(3, u.getName());
			psAddUser.setString(4, u.getEmail());
			psAddUser.setString(5, u.getCity());
			psAddUser.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Iterator<User> showUsers() {
		try {
			PreparedStatement psShowUser = dbConnection.prepareStatement("Select * from users");
			ResultSet resultShowUsers = psShowUser.executeQuery();
			ArrayList<User> list = new ArrayList<>();
			while(resultShowUsers.next()) {
				list.add(new User(
						resultShowUsers.getString(1),
						resultShowUsers.getString(2),
						resultShowUsers.getString(3),
						resultShowUsers.getString(4),
						resultShowUsers.getString(5)
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
	public void deleteUser(String username) {
		try {
			PreparedStatement psUpdateUser = dbConnection.prepareStatement("delete from users where username=?");
			psUpdateUser.setString(1,username);
			psUpdateUser.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(String username, String name, String email, String city) {
		try {
			PreparedStatement psUpdateUser = dbConnection.prepareStatement("update users set name=?, email=?, city=? where username=?;");
			psUpdateUser.setString(1,name);
			psUpdateUser.setString(2,email);
			psUpdateUser.setString(3,city);
			psUpdateUser.setString(4,username);
			psUpdateUser.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean validUser(String username, String password) {
		try {
			PreparedStatement psValidUser = dbConnection.prepareStatement("Select * from users where username=? and password=?");
			psValidUser.setString(1, username);
			psValidUser.setString(2, password);
			
			ResultSet resultValidUsers = psValidUser.executeQuery();
			if(resultValidUsers.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void passChange(String username, String newpass) {
		try {
			PreparedStatement psChangePass = dbConnection.prepareStatement("update users set password=? where username=?");
			psChangePass.setString(1, newpass);
			psChangePass.setString(2, username);
			
			psChangePass.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
