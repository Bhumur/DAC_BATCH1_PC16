package com.cdac.RestFullJPA.respo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdac.RestFullJPA.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	
}
