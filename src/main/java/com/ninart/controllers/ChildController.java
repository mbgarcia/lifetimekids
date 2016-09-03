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
import com.ninart.repository.IChildRepository;

@Controller
@RequestMapping("/child")
public class ChildController {	
	@Autowired
	public IChildRepository repository;
		
	@RequestMapping(method=GET)
	public String all(Model model){
		model.addAttribute("children", repository.findAll());
		return "children/index";
	}
	
	@RequestMapping(value="/save", method=POST)
	public String save(@Valid Child child, Errors errors){
		if (errors.hasErrors()){
			return "children/form";
		}
		
		repository.save(child);
		return "redirect:/child";
	}
	
	@RequestMapping(value="/new", method=GET)
	public String form(Model model){
		model.addAttribute("child", new Child());
		return "children/form";
	}
	
	@RequestMapping(value="/{id}", method=GET)
	public String show(@PathVariable long id, Model model){
		Child child = repository.findOne(id);
		model.addAttribute("child", child);
		return "children/show";
	}
}
