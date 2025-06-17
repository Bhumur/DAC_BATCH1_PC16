package com.cdac.BootMVCHibernate.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.BootMVCHibernate.entity.User;


@Controller
public class UserControler {

	@Autowired
	SessionFactory hiberFactory;
	
	@RequestMapping("/login")
	public void prepareUser(Model data) {
		data.addAttribute("objUser", new User());
		System.out.println("powndopiwdlkqald");
	}
	
	@RequestMapping("/auth")
	public ModelAndView authentication(@ModelAttribute("objUser")User objUser) {
		try(Session session = hiberFactory.openSession()){
			User obj = session.find(User.class, objUser.getUsername());
			if(obj!=null && obj.getPassword().equals(objUser.getPassword())) {
				return new ModelAndView("welcome","msg","hello brother");
			}else {
				return new ModelAndView("failure","msg","Bhag brother");
			}
		}
	}
}
