package com.cdac.CategoryRestAPI.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.CategoryRestAPI.dto.CategoryDto;
import com.cdac.CategoryRestAPI.service.CategoryServiceImpl;

@RestController
@RequestMapping("/Category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
	@Autowired
	CategoryServiceImpl cService;
	
	@GetMapping("/all")
	public Iterator<CategoryDto> showAllCategory(){
		return cService.showAllCategory();
	}

}
