package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.dto.UserDto;
import com.nt.model.User;
import com.nt.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@GetMapping("/login")
	public String getLogin(@ModelAttribute User userDetails) {
		return "user_login";	
	}
	
	@PostMapping("/login")
	public String processLogin(Map<String,Object> map,
							@ModelAttribute User user) {
		UserDto dto = new UserDto();
		String result= null;
		
		BeanUtils.copyProperties(user, dto);
		result=service.login(dto);
		map.put("output", result);
		return "user_login";
	}
	
	
}
