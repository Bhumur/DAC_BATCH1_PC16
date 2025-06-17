package com.cdac.RestFullJPA.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.RestFullJPA.entity.User;
import com.cdac.RestFullJPA.respo.UserRepository;

@RestController
public class SabkaController {
	
	@Autowired
	UserRepository uRepo;
	
	@GetMapping("/Users")
	public Iterator<User> getAll(){
		return uRepo.findAll().iterator();
	}

}
