package com.cdac.rest.UserRestAPI.service;

import java.util.Iterator;

import com.cdac.rest.UserRestAPI.dto.UserDTO;

public interface UserService {

	public boolean isValid(String username, String password);
	public Iterator<UserDTO> allUser();
}
