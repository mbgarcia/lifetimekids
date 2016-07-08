package com.ninart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(method=GET)
	public String home(){
		return "home";
	}
	
	@RequestMapping(value="login", method=GET)
	public String login(){
		return "login";
	}
}
