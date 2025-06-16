package com.cdac.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.beans.User;

import jakarta.validation.Valid;

@Controller
public class LoginController {
	
	@Autowired
	SessionFactory hiberSession;
	
	
	@RequestMapping(method = RequestMethod.GET , value = "/login")
	public void prepareUser(Model data) {
		System.out.println("in login controler");
		User objUser = new User();
		data.addAttribute("objUser",objUser);
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/login")
	public String checkUser(@Valid @ModelAttribute("objUser")User objUser,BindingResult result ) {
		if(result.hasErrors()) {
			return "login";
		}else {
			return "forward:Authuntication";
		}
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/Authuntication")
	public ModelAndView authunticateUser(@ModelAttribute("objUser")User objUser) {
		
		Session s = hiberSession.openSession();
		s.beginTransaction();
		com.cdac.entity.User u = s.find(com.cdac.entity.User.class, objUser.getUsername());
		System.out.println("auth controller");
		if(objUser.getPassword().equals(u.getPassword())) {
			return new ModelAndView("welcome","msg","Wlecome to page");
		}else {
			return new ModelAndView("failure","msg","INVALID USER");
		}
	}
}
