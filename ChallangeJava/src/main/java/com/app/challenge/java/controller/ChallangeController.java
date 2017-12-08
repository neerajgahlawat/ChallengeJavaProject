package com.app.challenge.java.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.challenge.java.model.Contact;
import com.app.challenge.java.model.Notify;
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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getData(Model model) {
		model.addAttribute("notify", new Notify());
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
		model.addAttribute("contact", new Contact());
		return "contact";

	}
	
	@RequestMapping(value= "/notifyme", method = RequestMethod.POST)
	public String notifyMe(@ModelAttribute("notify") Notify notify, Model model){
		logger.info("-------------Notify Me Started-------------");
		try{
		model.addAttribute("SUCCESS_MESSAGE", challengeService.setNotifyMe(notify));
		model.addAttribute("notify", new Notify());
		}catch(Exception exception){
			logger.error("Error In Notify Me",exception);
		}
		logger.info("-------------Notify Me End-----------------");
		return "index";
		
	}
	
	@RequestMapping(value= "/contactus", method = RequestMethod.POST)
	public String contactUs(@ModelAttribute("contact") Contact contact, Model model){
		logger.info("-------------Notify Me Started-------------");
		try{
			model.addAttribute("SUCCESS_MESSAGE", emailService.setContactUs(contact));
			model.addAttribute("contact", new Contact());
		}catch(Exception exception){
			logger.error("Error In Contact Us",exception);
		}
		logger.info("-------------Notify Me End-----------------");
		return "contact";
		
	}

}