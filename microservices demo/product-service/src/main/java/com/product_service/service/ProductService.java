package com.product_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_service.entity.Product;
import com.product_service.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Optional<Product> getById(Long id) {
        return repository.findById(id);
    }

    public Optional<Product> update(Long id, Product newProduct) {
        return repository.findById(id).map(product -> {
            product.setName(newProduct.getName());
            product.setPrice(newProduct.getPrice());
            product.setCategoryId(newProduct.getCategoryId());
            return repository.save(product);
        });
    }

    public boolean delete(Long id) {
        return repository.findById(id).map(product -> {
            repository.delete(product);
            return true;
        }).orElse(false);
    }

    public List<Product> getByCategoryId(Long categoryId) {
        return repository.findByCategoryId(categoryId);
    }
}
