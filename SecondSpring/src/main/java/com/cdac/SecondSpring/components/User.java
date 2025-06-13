package com.cdac.SecondSpring.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("objUser")
@Scope("prototype")
public class User {
	String username;
	String password;
	String name;
	String email;
	String city;
	public User() {}
	public User(String username, String pass) {
		this.username = username;
		this.password = pass;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

//	@Override
//	public String toString() {
//		return "User [username=" + username + ", password=" + password + ", name=" + name + ", email=" + email
//				+ ", city=" + city + "]";
//	}
	
}
