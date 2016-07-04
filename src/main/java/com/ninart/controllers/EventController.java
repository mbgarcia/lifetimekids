package com.ninart.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ninart.models.Child;
import com.ninart.models.Event;
import com.ninart.repository.IEventRepository;

@Controller
@RequestMapping("/child/{id}/events")
public class EventController {
	
	@Autowired
	IEventRepository eventRepository;
	
	@RequestMapping(method=GET)
	public String list(@PathVariable String id, Model model){
		Child child = new Child();
		child.setId(Long.valueOf(id));
		model.addAttribute("events", eventRepository.findByChild(child));
		
		return "events/index";
	}
	
	@RequestMapping(value="/new", method=GET)
	public String form(Model model){
		model.addAttribute("event", new Event());
		return "events/form";
	}
	
	@RequestMapping(value="/save", method=POST)
	public String save(@Valid Event event, Errors errors){
		if (errors.hasErrors()){
			return "events/form"; 
		}
		return "";
	}
}
