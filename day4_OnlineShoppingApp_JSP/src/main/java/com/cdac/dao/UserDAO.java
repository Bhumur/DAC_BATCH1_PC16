package com.cdac.dao;

import java.util.Iterator;

import com.cdac.tables.User;

public interface UserDAO {
	public void passChange(String username, String newpass);
	public boolean validUser(String username, String password);
	public Iterator<User> showUsers();
	public void deleteUser(String username);
	public void addUser(User u);
	void updateUser(String username, String name, String email, String city);
}
