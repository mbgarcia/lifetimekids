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
import com.ninart.models.Measure;
import com.ninart.repository.IMeasureRepository;

@Controller
@RequestMapping("/child/{childId}/measures")
public class MeasureController {
	
	@Autowired
	IMeasureRepository repository;
	
	
	@RequestMapping(method=GET)
	public String list(@PathVariable String childId, Model model){
		Child child = new Child(childId);
		model.addAttribute("measures", repository.findByChild(child));
		
		return "measures/index";
	}
	
	@RequestMapping(value="/new", method=GET)
	public String form(@PathVariable String childId, Model model){
		Measure measure = new Measure();
		measure.setChild(new Child(childId));

		model.addAttribute("measure", measure);
		
		return "measures/form";
	}
	
	@RequestMapping(value="/save", method=POST)
	public String save(@PathVariable String childId, @Valid Measure measure, Errors errors, Model model){
		measure.setChild(new Child(childId));
		
		if (errors.hasErrors()){
			return "measures/form"; 
		}
				
		repository.save(measure);
		return "redirect:/child/" + measure.getChild().getId() + "/measures";
	}
	
	@RequestMapping(value="/show/{measureId}", method=GET)
	public String show(@PathVariable long measureId, Model model){
		model.addAttribute("measure", repository.findOne(measureId));
		return "measures/show";
	}
}
