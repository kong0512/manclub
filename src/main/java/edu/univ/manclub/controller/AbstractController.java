package edu.univ.manclub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public abstract class AbstractController {

	protected Logger logger;
	
	protected AbstractController(Class<?> type){
		this.logger = LoggerFactory.getLogger(type);
	}
	
	protected String getCurrentUserID(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userID = user.getUsername();
		// username is studentID
		logger.info("Get Current User ID = "+ userID);
		
		return userID;
	}
}
