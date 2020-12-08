package com.ra2ocde.springsecuritydemo.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final Logger log =  Logger.getLogger(RegisterController.class.getSimpleName());

	@RequestMapping(value = {"/loginPage"},  method = RequestMethod.GET)
	public String showMyLoginPage() {
		log.info(">>> REQUEST to GET  \"/loginPage\"");
		return "login";
	}
	
	 @RequestMapping(value = "/access-denied" ,  method = RequestMethod.GET)
	 public String showAccessDenied() {
		 log.info(" >>>REQUEST to GET  \"/access-denied\"");
		 return "access-denied";
	 }
}
