package com.cdac.CategoryRestAPI.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdac.CategoryRestAPI.entity.CategoryEntity;
@Repository
public interface CategoryRepo extends CrudRepository<CategoryEntity, Integer> {

}
