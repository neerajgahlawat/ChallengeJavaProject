package com.app.challenge.java.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.challenge.java.DTO.PasswordResetTokenDTO;
import com.app.challenge.java.model.SignUp;
import com.app.challenge.java.model.UpdatePassword;
import com.app.challenge.java.model.User;
import com.app.challenge.java.service.UserService;

@Controller
public class UserController {

	private final static Logger logger = Logger
			.getLogger(UserController.class);
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
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
	  @RequestParam("id") long id, @RequestParam("token") String token, HttpSession session) {
	    String result = userService.validatePasswordResetToken(id, token);
	    if (result != null) {
	        return "redirect:/user/login/home";
	    }
	    session.setAttribute("userPassUpdateId", id);
	    model.addAttribute("updatePassword", new UpdatePassword());
	    return "updatePassword";
	}
	
	@RequestMapping(value = "/user/updatePassword", method = RequestMethod.POST)
	public String savePassword(@ModelAttribute("updatePassword") UpdatePassword updatePassword, HttpSession session, Model model) {
		logger.info("-------------Update Password Started-------------");
		try{
			Long userId= (Long) session.getAttribute("userPassUpdateId");
			model.addAttribute("PASSWORD_UPDATED", userService.updateUserPassword(updatePassword, userId));
			model.addAttribute("user", null);
		}catch(Exception exception){
			logger.error("Error in update Password", exception);
		}
		logger.info("-------------updpate Password End-----------------");
		return "updatePassword";
	}
	
	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	/**
	 * This method returns true if users is already authenticated [logged-in],
	 * else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder
				.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}
}
