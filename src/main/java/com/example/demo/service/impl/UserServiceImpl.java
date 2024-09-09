package com.example.demo.service.impl;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.entities.UserAuth;
import com.example.demo.message.MessageStatus;
import com.example.demo.model.Login;
import com.example.demo.model.UserAuthOutput;
import com.example.demo.repository.UserAuthRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserAuthRepository userAuthRepository;


	
	@Override
	public MessageStatus createUser(User user) {
		
		MessageStatus msg = new MessageStatus();
	
		userRepository.save(user);
		return new MessageStatus("User has been sucessfully Create", HttpServletResponse.SC_OK);
		
	}

	@Override
	public MessageStatus auth(Login userAuthInput){
		MessageStatus msg = new MessageStatus();
		
		User user = userRepository.findByEmailAndPassword(userAuthInput.getEmail(), userAuthInput.getPassword());// need to encrypt password
		if (user == null) {
		 return new MessageStatus("User name or password wrong ", HttpServletResponse.SC_NOT_ACCEPTABLE);	
		 } 
			UserAuth userAuth = new UserAuth();
			userAuth.setUserId(user.getId());
			userAuth.setEmail(user.getEmail());
			userAuth.setLoginTime(new Date());
			userAuth.setExpiredTime(getExpiredTime(1,0)); //number of hour ,number of day

			userAuthRepository.save(userAuth); // Create login entry in tbl_auth

			UserAuthOutput userAuthOutput = new UserAuthOutput();
			userAuthOutput.setEmail(userAuthInput.getEmail());
			userAuthOutput.setFirstName(user.getFirstName());
			userAuthOutput.setLastName(user.getLastName());
			userAuthOutput.setTokenExpiredTime(userAuth.getExpiredTime());
			userAuthOutput.setTokenId(userAuth.getTokenId());

			msg.setData(userAuthOutput);
			msg.setMessage("Sign in sucessfull");

			msg.setStatusCode(HttpServletResponse.SC_OK);
			return msg;
		
	}

	public Date getPasscodeExpired() {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, 3);
		return now.getTime();
	}

	public Date getPasswordExpired() {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MONTH, 1);
		return now.getTime();
	}
	
	public Date getExpiredTime(int hour,int day) {
		Calendar now = Calendar.getInstance();
		if(hour >0) now.add(Calendar.HOUR, hour);
		if(day >0) now.add(Calendar.DATE, day);
		return now.getTime();
	}



}
