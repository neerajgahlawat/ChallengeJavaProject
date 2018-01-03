package com.app.challenge.java.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.challenge.java.DTO.PasswordResetTokenDTO;
import com.app.challenge.java.model.SignUp;
import com.app.challenge.java.model.User;
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
	
	
	
	@RequestMapping(value = "/user/reset/id", method = RequestMethod.GET)
	public String getResetEmailId() {
		return "forgotPassword";
	}
	
	@RequestMapping(value = "/user/resetPassword", method = RequestMethod.GET)
	public String resetPassword(HttpServletRequest request,
			@RequestParam("email") String userEmail, Model model) {
		logger.info("-------------Reset Password Started-------------");
		try{
		model.addAttribute("RESET_PASS_MSG", userService.findUserByEmail(userEmail, request));
		}catch(Exception exception){
			logger.error("Error Reset Password", exception);
		}
		logger.info("-------------Reset Password End-----------------");
		return "forgotPassword";
	}
	
	
	@RequestMapping(value = "/user/changePassword", method = RequestMethod.GET)
	public String showChangePasswordPage(Locale locale, Model model, 
	  @RequestParam("id") long id, @RequestParam("token") String token) {
	    String result = userService.validatePasswordResetToken(id, token);
	    if (result != null) {
	       /* model.addAttribute("message", 
	          messages.getMessage("auth.message." + result, null, locale));
	        return "redirect:/login?lang=" + locale.getLanguage();*/
	    }
	    return "redirect:/updatePassword.html?lang=" + locale.getLanguage();
	}
}
