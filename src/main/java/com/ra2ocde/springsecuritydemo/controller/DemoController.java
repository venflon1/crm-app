package com.ra2ocde.springsecuritydemo.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {
	private static final Logger log =  Logger.getLogger(RegisterController.class.getSimpleName());

	 @RequestMapping(value = "/" ,  method = RequestMethod.GET)
	 public String showHome() {
		log.info(">>> REQUEST to GET  \"/home\"");
		 return "home";
	 }
	 
	 @RequestMapping(value = "/leaders" ,  method = RequestMethod.GET)
	 public String showLeaders() {
		log.info(">>> REQUEST to GET  \"/leaders\"");
		 return "leaders";
	 }
	 
	 @RequestMapping(value = "/systems" ,  method = RequestMethod.GET)
	 public String showSystems() {
		log.info(">>> REQUEST to GET  \"/systems\"");
		 return "systems";
	 }
}