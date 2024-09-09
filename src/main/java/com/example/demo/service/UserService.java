package com.example.demo.service;

import com.example.demo.entities.User;
import com.example.demo.message.MessageStatus;
import com.example.demo.model.Login;

public interface UserService {
	public MessageStatus createUser(User user);
	public MessageStatus auth(Login userAuthInput);
}