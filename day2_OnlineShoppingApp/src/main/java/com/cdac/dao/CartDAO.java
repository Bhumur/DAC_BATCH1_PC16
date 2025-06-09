package com.cdac.dao;

import java.util.Iterator;

public interface CartDAO {
	public Iterator<Cart> showCart(String username);
}
