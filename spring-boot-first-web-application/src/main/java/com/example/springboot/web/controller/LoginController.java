package com.example.springboot.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.springboot.web.service.LoginService;


@Controller
@SessionAttributes("name")// here we persist the username in session and used accross the application

public class LoginController {
	
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	//@ResponseBody
	public String loginMessage(/*@RequestParam String name*/ ModelMap model) {
		/* model.put("name", name); */
		return "login";
	}

	@RequestMapping(value = "/login", method=RequestMethod.POST)
	//@ResponseBody
	public String showWelcome(@RequestParam String name ,@RequestParam String password ,ModelMap model) {
		 
	boolean isValid=	loginService.validateUser(name, password);
	if(!isValid)
	{
		model.put("message", "invalid credentials");
		return "login";
	}
	else
	{
		 model.put("name", name); 
		 
		return "welcome";
	}
	}
}
