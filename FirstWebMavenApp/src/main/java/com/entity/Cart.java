package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@ManyToOne
	@JoinColumn(name="username", insertable = false, updatable = false)
	User user;
	
	@EmbeddedId
	CartId cartId;
	@Column(name="productName")
	String name;
	@Column(name="quantity")
	int quantity;
	@Column(name="price")
	float price;
	public Cart() {}
	public Cart(CartId cartId, String name, int quantity, float price) {
		super();
		this.cartId = cartId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public CartId getCartId() {
		return cartId;
	}
	public void setCartId(CartId cartId) {
		this.cartId = cartId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Cart [user=" + user + ", cartId=" + cartId + ", name=" + name + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
	
}
