package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.dto.EmployeeDto;
import com.nt.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/home")
	public String getHome() {
		return "welcome";
	}
	
	@GetMapping("/allemp")
	public String getAll(Map<String,Object> map) {
		List<EmployeeDto> listDto= null;
		listDto =service.fetchEmp();
		map.put("empDetails", listDto);
		return "result";
		
	}
}
