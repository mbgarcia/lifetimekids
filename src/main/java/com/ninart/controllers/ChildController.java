package com.ninart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ChildController {
		
	@RequestMapping(method=RequestMethod.GET)
	public String all(){
		return "home";
	}
}
