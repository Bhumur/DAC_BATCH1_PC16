package com.dao.impl;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Product;
import com.entity.Cart;
import com.entity.CartId;
import com.entity.ProductId;
import com.entity.User;


public class CartDAOImp implements CartDAO {
	Session session;
	
	public CartDAOImp(SessionFactory sec) {
		this.session = sec.openSession();
	}
	
	@Override
	public Iterator<Cart> showCart(String username) {
		User u = session.find(User.class, username);
		return u.getCart().iterator();
	}
	
	@Override
	public void addToCart(String u, int cid, int pid) {
		Product p = session.find(Product.class,new ProductId(cid,pid));
		CartId cartid = new CartId(u,cid,pid);
		Cart c = session.find(Cart.class, cartid);
		session.beginTransaction();
		if(c==null) {
			c = new Cart(cartid,p.getProductsName(),1,p.getProductsPrice());
			session.persist(c);
		}else {
			c=new Cart(c.getCartId(),c.getName(),c.getQuantity()+1,c.getPrice());
			session.merge(c);
		}
		session.getTransaction().commit();
	}

	@Override
	public void emptyCart(String username) {
		User u = session.find(User.class,username);
		Iterator<Cart> itr = u.getCart().iterator();
		while(itr.hasNext()) {
			Cart c = itr.next();
			session.beginTransaction();
			session.remove(c);
			session.getTransaction().commit();
		}
	}
	
	public void deleteItem(String username, int cid, int pid) {
		CartId cartid = new CartId(username,cid,pid);
		session.beginTransaction();
		session.remove(cartid);
		session.getTransaction().commit();
	}

	@Override
	public void removeQuantityFromCart(String username, int cId, int pId) {
		CartId cartid = new CartId(username,cId,pId);
		Cart c = session.find(Cart.class, cartid);
		session.beginTransaction();
		if(c.getQuantity()==1) {
			session.remove(cartid);
		}else {
			Cart x=new Cart(c.getCartId(),c.getName(),c.getQuantity()-1,c.getPrice());
			session.merge(x);
		}
		session.getTransaction().commit();
	}

	@Override
	public void addQuantityFromCart(String username, int cId, int pId) {
		CartId cartid = new CartId(username,cId,pId);
		Cart c = session.find(Cart.class, cartid);
		Cart x=new Cart(c.getCartId(),c.getName(),c.getQuantity()+1,c.getPrice());
		session.beginTransaction();
		session.merge(x);
		session.getTransaction().commit();
	}
}
