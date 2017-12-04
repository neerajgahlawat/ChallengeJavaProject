package org.app.challenge.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChallangeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getData() {

		ModelAndView model = new ModelAndView("index");
	
		return model;

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
	public ModelAndView getContact() {

		ModelAndView model = new ModelAndView("contact");
	
		return model;

	}

}