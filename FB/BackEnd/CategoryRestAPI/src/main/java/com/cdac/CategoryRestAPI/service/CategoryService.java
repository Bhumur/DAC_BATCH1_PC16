package com.cdac.CategoryRestAPI.service;

import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.cdac.CategoryRestAPI.dto.CategoryDto;

@Service
public interface CategoryService {
	public Iterator<CategoryDto> showAllCategory();
}
