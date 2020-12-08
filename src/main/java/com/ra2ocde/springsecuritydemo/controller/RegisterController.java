package com.ra2ocde.springsecuritydemo.controller;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
	private static final Logger log =  Logger.getLogger(RegisterController.class.getSimpleName());
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterPage() {
		log.info(">>> REQUEST to GET  \"/register\"");
		return "register";
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@RequestParam(required = true) Map<String, Object> registrationData) {
		log.info(">>> REQUEST to POST  \"/registerUser\"" + " - param=" + registrationData);
		return "register";
	}
}
