package com.cdac.HiberSpringConsole.DAO;

import java.util.Iterator;

import com.cdac.HiberSpringConsole.entity.User;


public interface UserDAO {
	public Iterator<User> showUser();
	public boolean addUser();
}
