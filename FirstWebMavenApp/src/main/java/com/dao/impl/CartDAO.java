package com.dao.impl;

import java.util.Iterator;

import com.entity.Cart;


public interface CartDAO {
	public Iterator<Cart> showCart(String username);
	void emptyCart(String username);
	void addToCart(String u, int cid, int pid);
	void removeQuantityFromCart(String username, int cId, int pId);
	void addQuantityFromCart(String username, int cId, int pId);
	
}
