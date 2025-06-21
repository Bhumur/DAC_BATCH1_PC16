package com.cdac.rest.UserRestAPI.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdac.rest.UserRestAPI.entity.User;

@Repository
public interface UserRespo extends CrudRepository<User, String>{

}
