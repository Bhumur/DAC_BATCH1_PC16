package com.cdac.CategoryRestAPI.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.CategoryRestAPI.dto.CategoryDto;
import com.cdac.CategoryRestAPI.entity.CategoryEntity;
import com.cdac.CategoryRestAPI.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo cRepo;
	
	@Override
	public Iterator<CategoryDto> showAllCategory() {
		Iterator<CategoryEntity> uEntityList = cRepo.findAll().iterator();
		ArrayList<CategoryDto> list = new ArrayList<CategoryDto>();
		while(uEntityList.hasNext()) {
			CategoryDto category = new CategoryDto();
			BeanUtils.copyProperties(uEntityList.next(), category);
			list.add(category);
		}
		return list.iterator();
	}

}
