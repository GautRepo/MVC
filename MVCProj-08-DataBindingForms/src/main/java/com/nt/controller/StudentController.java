package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Student;

@Controller
public class StudentController {
	
	/*@GetMapping("/register")
	public String getForm(@ModelAttribute("strf")Student st) {
		System.out.println("StudentController.getForm()"+st);
		st.setSadd("Patna");
		return "student_form";
	}
	
	@PostMapping("/register")
	public String processForm(Map<String,Object> map,@ModelAttribute("strf")Student st) {
		System.out.println("StudentController.processForm()"+st);
		return "result";
	}*/
	
	@GetMapping("/register")
	public String getForm(@ModelAttribute Student st) {
		System.out.println("StudentController.getForm()"+st);
		st.setSadd("Patna");
		return "student_form";
	}
	
	@PostMapping("/register")
	public String processForm(Map<String,Object> map,@ModelAttribute Student st) {
		System.out.println("StudentController.processForm()"+st);
		return "result";
	}
	
	/*@GetMapping("/links")
	public String showLinks(@RequestParam("snum") int sno
					,@RequestParam("name") String sname) {
		return "show_links";
	}*/
	
	@GetMapping("/links")
	public String showLinks(@RequestParam int sno
					,@RequestParam String sname) {
		return "show_links";
	}

}
