package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.Person;

@Controller
public class PersonController {
	
	@GetMapping("/person")
	public String showForwm(@ModelAttribute("perFrm") Person pers) {
		
		return "person_form";
	}

}
