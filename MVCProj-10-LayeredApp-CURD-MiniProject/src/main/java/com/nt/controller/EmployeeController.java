package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.dto.EmployeeDto;
import com.nt.model.Employee;
import com.nt.service.IEmployeeService;
import com.nt.validator.EmployeeValidator;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	@Autowired
	private EmployeeValidator validator;

	@GetMapping("/home.htm")
	public String getHome() {
		return "welcome";
	}

	@GetMapping("/allemp.htm")
	public String getAll(Map<String, Object> map) {
		List<EmployeeDto> listDto = null;
		listDto = service.fetchEmp();
		map.put("empDetails", listDto);
		return "result";
	}

	
	  @GetMapping("/empSave.htm")
	  public String showEmployee(@ModelAttribute("empFrm") Employee emp) {
		  
		  return "employee_register";
	  }
	  
	  @PostMapping("/empSave.htm")
	  public String insertEmp(RedirectAttributes map,@ModelAttribute("empFrm") Employee emp,
			  BindingResult errors) {
		  EmployeeDto dto = null;
		  String result= null;
		  
		  if(emp.getVflag().equalsIgnoreCase("no")) {
		  if(validator.supports(emp.getClass()))
			  validator.validate(emp, errors);
			
		  }
		  if(errors.hasErrors())
			  return "employee_register";  
		  
		  
		  dto = new EmployeeDto();
		  BeanUtils.copyProperties(emp, dto);
		  result = service.registerEmp(dto);
		  
		  map.addFlashAttribute("msg", result);
		  
		  return "redirect:allemp.htm";
	  }
	  
	  @GetMapping("/deleteEmp.htm")
	  public String removeEmplo(RedirectAttributes redirect,@RequestParam int eno) {
		  String result= null;
		  
		  result=service.removeEmp(eno);
		  redirect.addFlashAttribute("msg", result);
		  return "redirect:allemp.htm";
	  }
	  
	  @GetMapping("/editEmp.htm")
	  public String editEmp(@RequestParam int eno,
			  				@ModelAttribute Employee emp) {
		  EmployeeDto dto =null;
		  
		  dto=service.fetchEmpById(eno);
		  BeanUtils.copyProperties(dto, emp);
		  
		  return "employee_edit";
	  }
	  
	  @PostMapping("/editEmp.htm")
	  public String updateEmplo(RedirectAttributes redirect,@ModelAttribute Employee employee,
			  					BindingResult errors) {
		  String result =null;
		  EmployeeDto dto = new EmployeeDto();
		  
		  if(employee.getVflag().equalsIgnoreCase("no")) {
		  if(validator.supports(employee.getClass()))
			  validator.validate(employee, errors);
			
		  }
		  
		  if(errors.hasErrors())
			  return "employee_edit";
		  
		  
		  BeanUtils.copyProperties(employee, dto);
		  result=service.modifyEmp(dto);
		 
		  redirect.addFlashAttribute("msg", result);
		  return "redirect:allemp.htm";
	  }
	  
	  
	  @ModelAttribute("deptsinfo")
	  public List<Integer> populateDeptNo(){

		  return service.fetchAllDept();
		  
	  }
	 

}
