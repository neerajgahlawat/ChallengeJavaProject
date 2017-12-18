package com.app.challenge.java.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.challenge.java.model.SignUp;
import com.app.challenge.java.service.UserService;

@Controller
public class UserController {

	private final static Logger logger = Logger
			.getLogger(UserController.class);
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping(value = "/user/signUp", method = RequestMethod.POST)
	public String notifyMe(@ModelAttribute("signUp") SignUp signUp, Model model) {
		logger.info("-------------sign Up Started-------------");
		try {
			model.addAttribute("RESPONSE_MESSAGE", userService.setUserSignUp(signUp)) ;
			model.addAttribute("signUp", new SignUp());
		} catch (Exception exception) {
			logger.error("Error In sign Up", exception);
		}
		logger.info("-------------sign Up End-----------------");
		return "index";

	}
	
}
