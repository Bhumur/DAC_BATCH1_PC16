package com.category_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.category_service.entity.Category;
import com.category_service.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category save(Category category) {
        return repository.save(category);
    }

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Optional<Category> getById(Long id) {
        return repository.findById(id);
    }

    public Optional<Category> update(Long id, Category newCategory) {
        return repository.findById(id).map(category -> {
            category.setName(newCategory.getName());
            return repository.save(category);
        });
    }

    public boolean delete(Long id) {
        return repository.findById(id).map(category -> {
            repository.delete(category);
            return true;
        }).orElse(false);
    }
}