package com.cdac.rest.UserRestAPI.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.rest.UserRestAPI.dto.UserDTO;
import com.cdac.rest.UserRestAPI.repo.UserRespo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRespo uRepo;
	
	@Override
	public boolean isValid(String username, String password) {
		Optional<com.cdac.rest.UserRestAPI.entity.User> u = uRepo.findById(username);
		if(u.isEmpty()) {
			return false;
		}
		com.cdac.rest.UserRestAPI.entity.User user = u.get();
		if(user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<UserDTO> allUser() {
		Iterator<com.cdac.rest.UserRestAPI.entity.User> u =  uRepo.findAll().iterator();
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
		while(u.hasNext()) {
			com.cdac.rest.UserRestAPI.entity.User user = u.next();
			UserDTO x = new UserDTO();
			BeanUtils.copyProperties(x, user);
			userList.add(x);
		}
		return userList.iterator();
	}

}
