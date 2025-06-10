package com.cdac.dao;

import java.util.Iterator;

import com.cdac.tables.Cart;

public interface CartDAO {
	public Iterator<Cart> showCart(String username);
	public void removeFromCart(String username, int cId, int pId);
	void addToCart(String u, int cid, int pid, float price, String name);
	void emptyCart(String username);
	
}
