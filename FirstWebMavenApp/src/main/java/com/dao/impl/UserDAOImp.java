package com.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.User;

import jakarta.servlet.ServletContext;


public class UserDAOImp implements UserDAO {
	Session hiberSession =null;
	public UserDAOImp(SessionFactory factory) {
		this.hiberSession = factory.openSession();
	}

	@Override
	public void addUser(User u) {
		hiberSession.beginTransaction();
		hiberSession.persist(u);
		hiberSession.getTransaction().commit();
	}

	@Override
	public Iterator<User> showUsers() {
		return null;
	}

	@Override
	public void deleteUser(String username) {
		

	}

	@Override
	public void updateUser(String username, String name, String email, String city) {
		
	}

	@Override
	public boolean validUser(String username, String password) {
		User u = hiberSession.find(User.class, username);
		if(u.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public void passChange(String username, String newpass) {
		
	}

}
