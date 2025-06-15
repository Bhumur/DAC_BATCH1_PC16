package com.cdac.HiberSpringConsole.DAO;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdac.HiberSpringConsole.entity.User;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session;
	
	@PostConstruct
	public void startUserDAO() {
		session = sessionFactory.openSession();
	}
	
	@PreDestroy
	public void releaseUserDAO() {
		session.close();
	}
	
	@Override
	public Iterator<User> showUser() {
		return null;
	}

	@Override
	public boolean addUser() {
		User u = new User("Ram","ram","Ram Agrawal", "ram@gmail.com","jaipur");
		session.beginTransaction();
		session.persist(u);
		session.getTransaction().commit();
		return false;
	}

}
