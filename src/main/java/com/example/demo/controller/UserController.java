package com.example.demo.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.message.MessageStatus;
import com.example.demo.model.Login;
import com.example.demo.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = { "/users" })
	public MessageStatus CreateUser(@Valid @RequestBody User user,
			HttpServletRequest req, HttpServletResponse resp) {

		MessageStatus msg = new MessageStatus();
		msg = userService.createUser(user);
		
		return msg; 
	}
	
	@PostMapping(value = "users/login")
	public MessageStatus login(@Valid @RequestBody Login login, HttpServletRequest req,
			HttpServletResponse resp) {
		return userService.auth(login);
	}
	
	
}
