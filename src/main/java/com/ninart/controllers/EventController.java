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
@RequestMapping("/child/{childId}/events")
public class EventController {
	
	@Autowired
	IEventRepository repository;
	
	
	@RequestMapping(method=GET)
	public String list(@PathVariable String childId, Model model){
		Child child = new Child(childId);
		model.addAttribute("events", repository.findByChild(child));
		
		return "events/index";
	}
	
	@RequestMapping(value="/new", method=GET)
	public String form(@PathVariable String childId, Model model){
		Event event = new Event();
		event.setChild(new Child(childId));

		model.addAttribute("event", event);
		
		return "events/form";
	}
	
	@RequestMapping(value="/save", method=POST)
	public String save(@PathVariable String childId, @Valid Event event, Errors errors, Model model){
		event.setChild(new Child(childId));
		
		if (errors.hasErrors()){
			return "events/form"; 
		}
				
		repository.save(event);
		return "redirect:/child/" + event.getChild().getId() + "/events";
	}
	
	@RequestMapping(value="/show/{eventId}", method=GET)
	public String show(@PathVariable long eventId, Model model){
		model.addAttribute("event", repository.findOne(eventId));
		return "events/show";
	}
}
