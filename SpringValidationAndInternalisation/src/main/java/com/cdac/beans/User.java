package com.cdac.beans;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {
	@NotEmpty(message = "not empty")
	@Size(min = 5, max = 10, message = "Enter Less then 10 charater and more than 5")
	String username;
	@NotEmpty(message = "Cant be empty")
	String password;
	public User() {}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
}
