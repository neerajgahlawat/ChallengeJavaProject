package com.app.challenge.java.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.challenge.java.service.UserService;

@Controller
public class AjaxController {

	private final static Logger logger = Logger
			.getLogger(ChallangeController.class);

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@RequestMapping(value = "/user/exists", method = RequestMethod.GET, produces = "text/plain")
	public @ResponseBody
	String getUserInfo(@RequestParam("user") String user) {
		String response = null;
		try {
			boolean isExists = userService.findBySSOIsExists(user);
			if (isExists) {
				response = "SUCCESS";
			}else{
				response = "FAILURE";
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return response;

	}
}
