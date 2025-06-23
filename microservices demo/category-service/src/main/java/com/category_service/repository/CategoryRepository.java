package com.category_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.category_service.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}

