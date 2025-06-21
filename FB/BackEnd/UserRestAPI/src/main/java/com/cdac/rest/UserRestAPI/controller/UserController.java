package com.cdac.rest.UserRestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.rest.UserRestAPI.dto.UserDTO;
import com.cdac.rest.UserRestAPI.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:3000") // Replace with your frontend origin
public class UserController {
    @Autowired
    UserService uService;

    @PostMapping("/isvalid")
    public boolean isValidUser(@RequestBody UserDTO u) {
        System.out.println("dfasd");
        String userName = u.getUsername();
        String password = u.getPassword();
        return uService.isValid(userName, password);
    }
}
