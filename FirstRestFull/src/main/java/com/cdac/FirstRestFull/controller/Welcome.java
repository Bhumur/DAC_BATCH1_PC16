package com.cdac.FirstRestFull.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.FirstRestFull.entity.User;

@RestController
public class Welcome {
	@GetMapping("/welcome")
	public String welcome() {
		return "Hello form Server";
	}
	
	@GetMapping("/getUser")
	public User GetUser() {
		User u = new User("Bhumur","bhumur");
		return u;
	}
}
