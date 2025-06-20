package com.cdac.rest.UserRestAPI.dto;

public class Validationdto {
	String username;
	String password;
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
	public Validationdto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Validationdto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Validationdto [username=" + username + ", password=" + password + "]";
	}
	
}
