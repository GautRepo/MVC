package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;

@Component("empValidation")
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee emp = null;
		
		emp=(Employee) target;
		
		if(emp.getEname()==null || emp.getEname().isEmpty()) {
			errors.rejectValue("ename","emp.ename.required");
		}
		
		else if(emp.getEname().length()<5|| emp.getEname().length()>10) {
			errors.rejectValue("ename","emp.ename.length");
		}
		
		if(emp.getJob()==null || emp.getJob().isEmpty()) {
			errors.rejectValue("job", "emp.job.required");
		}
		
		else if(emp.getJob().length()<5|| emp.getJob().length()>10) {
			errors.rejectValue("job", "emp.job.length");
		}
		
		if(emp.getJob().equalsIgnoreCase("clerk")) {
			errors.rejectValue("job", "blocked.job");
		}
		
		if(emp.getSal()==null ) {
			errors.rejectValue("sal", "emp.sal.required");
		}
		
		else if(emp.getSal()<100 || emp.getSal()>100000) {
			errors.rejectValue("sal", "emp.sal.range");
		}

	}

}
