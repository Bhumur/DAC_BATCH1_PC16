package com.cdac.acts.PagingWithRestAPI.controller;

import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.acts.PagingWithRestAPI.dto.User;

@RestController
@RequestMapping("/data")
public class AllController {

	
	@GetMapping("/getAllUsers")
	public Iterator<User> getAllUsers(){
		
	}
}
