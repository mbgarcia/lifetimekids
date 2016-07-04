package com.ninart.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ninart.models.Child;
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
}
