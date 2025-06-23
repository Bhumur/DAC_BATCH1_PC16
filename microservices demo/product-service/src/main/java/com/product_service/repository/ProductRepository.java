package com.product_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
}