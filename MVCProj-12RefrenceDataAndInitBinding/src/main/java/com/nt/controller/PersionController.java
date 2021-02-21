package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Persion;

@Controller
public class PersionController {

	@GetMapping("/person")
	public String showForm(@ModelAttribute("perfrm") Persion pers) {
		
		return "person_form";
	}
	
	@PostMapping("/person")
	public String handleForm(Map<String,Object> map,@ModelAttribute("perfrm") Persion pers) {
		System.out.println(pers);
		return "sucess_page";
	}
	
	@InitBinder
	public void myinitBinder(ServletRequestDataBinder binder) {
		System.out.println("PersionController.myinitBinder()");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
	}
	
	
	@ModelAttribute("genderList")
	public List<String> getGenderList(){
		List<String> gendersList=List.of("male","female");
		return gendersList;
	}
	
	@ModelAttribute("hobbyList")
	public List<String> gethobiesList(){
		List<String> hobbiesList=List.of("gaming","flurting","roaming","running");
		return hobbiesList;
	}
	
	@ModelAttribute("qlyList")
	public List<String> getQlfyList(){
		List<String> qulfyList=List.of("BE","MCA","EE","CS","M.Tech");
		return qulfyList;
	}
	
	@ModelAttribute("clrList")
	public List<String> getclrList(){
		List<String> clrList=List.of("red","white","orange","black","pink");
		return clrList;
	}
}

















