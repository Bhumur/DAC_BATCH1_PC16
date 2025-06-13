package com.dao.impl;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Category;



public class CategoryDAOImp implements CategoryDAO {
	Session session = null;
	public CategoryDAOImp(SessionFactory sec) {
		super();
		this.session = sec.openSession();
	}

	@Override
	public void addCategory(Category c ) {			
			session.beginTransaction();
			session.persist(c);
			session.getTransaction().commit();
	}

	@Override
	public Iterator<Category> allCategory() {
		return session.createQuery("from Category", Category.class).getResultList().iterator();
	}

	@Override
	public void deleteCategory(int categoryId) {
		session.beginTransaction();
		session.remove(session.find(Category.class, categoryId));
		session.getTransaction().commit();
	}

	@Override
	public void updateCategory(int categoryId, String name, String dis, String img) {
		session.beginTransaction();
		Category c = new Category(categoryId,name,dis,img);
		session.merge(c);
		session.getTransaction().commit();
	}

}
