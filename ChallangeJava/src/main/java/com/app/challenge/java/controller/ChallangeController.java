package com.app.challenge.java.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import org.springframework.web.servlet.ModelAndView;

import com.app.challenge.java.model.Contact;
import com.app.challenge.java.model.Notify;
import com.app.challenge.java.model.SignUp;
import com.app.challenge.java.service.ChallengeService;
import com.app.challenge.java.service.EmailService;

@Controller
public class ChallangeController {

	private final static Logger logger = Logger
			.getLogger(ChallangeController.class);

	@Autowired
	@Qualifier("challengeService")
	ChallengeService challengeService;

	@Autowired
	@Qualifier("emailService")
	EmailService emailService;
	
	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getData(Model model) {
		model.addAttribute("signUp", new SignUp());
		model.addAttribute("ALL_ASK_QUESTIONS", challengeService.getAllAskedQuestionList());
		String loginUser = getPrincipal();
		if(loginUser != null && !loginUser.equals("anonymousUser")){
			model.addAttribute("user", loginUser);
		}
		return "index";
	}
	
	@RequestMapping(value = "/user/login/home", method = RequestMethod.GET)
	public String getLoginUserOnHome(Model model) {
		model.addAttribute("signUp", new SignUp());
		model.addAttribute("ALL_ASK_QUESTIONS", challengeService.getAllAskedQuestionList());
		String loginUser = getPrincipal();
		if(loginUser != null && !loginUser.equals("anonymousUser")){
			model.addAttribute("user", loginUser);
		}
		return "index";
	}

	@RequestMapping(value = "/tech", method = RequestMethod.GET)
	public ModelAndView getTechnologies() {

		ModelAndView model = new ModelAndView("technology");

		return model;

	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView getAbout() {

		ModelAndView model = new ModelAndView("about");

		return model;

	}

	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public ModelAndView getBlog() {

		ModelAndView model = new ModelAndView("blog");

		return model;

	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String getContact(Model model) {
		model.addAttribute("notify", new Notify());
		return "contact";

	}

	@RequestMapping(value = "/notifyme", method = RequestMethod.POST)
	public String notifyMe(@ModelAttribute("notify") Notify notify, Model model) {
		logger.info("-------------Notify Me Started-------------");
		try {
			model.addAttribute("SUCCESS_MESSAGE",
					challengeService.setNotifyMe(notify));
			model.addAttribute("notify", new Notify());
		} catch (Exception exception) {
			logger.error("Error In Notify Me", exception);
		}
		logger.info("-------------Notify Me End-----------------");
		return "index";

	}

	@RequestMapping(value = "/contactus", method = RequestMethod.POST)
	public String contactUs(@ModelAttribute("contact") Contact contact,
			Model model) {
		logger.info("-------------Notify Me Started-------------");
		try {
			model.addAttribute("SUCCESS_MESSAGE",
					emailService.setContactUs(contact));
			model.addAttribute("contact", new Contact());
		} catch (Exception exception) {
			logger.error("Error In Contact Us", exception);
		}
		logger.info("-------------Notify Me End-----------------");
		return "contact";
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