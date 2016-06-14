package com.ninart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ninart.repository.ChildRepository;

@Controller
@RequestMapping("/")
public class ChildController {
	
	@Autowired
	public ChildRepository childRepository;
		
	@RequestMapping(method=RequestMethod.GET)
	public String all(Model model){
		model.addAttribute("children", childRepository.findAll());
		return "home";
	}
}
