package com.ninart.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ninart.models.Child;
import com.ninart.repository.IChildRepository;

@Controller
@RequestMapping("/")
public class ChildController {
	
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	 
	@Autowired
	public IChildRepository repository;
		
	@RequestMapping(method=GET)
	public String all(Model model){
		model.addAttribute("children", repository.findAll());
		return "home";
	}
	
	@RequestMapping(value="/save", method=POST)
	public String save(@Valid Child child, Errors errors){
		if (errors.hasErrors()){
			return "form";
		}
		
		repository.save(child);
		return "redirect:/";
	}
	
	@RequestMapping(value="/new", method=GET)
	public String form(Model model){
		model.addAttribute("child", new Child());
		return "form";
	}
}
