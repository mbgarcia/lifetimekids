package com.ninart.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/child/{id}/events")
public class EventController {
	
	@RequestMapping(method=GET)
	public String list(@PathVariable String id){
		return "events/index";
		
	}

}
