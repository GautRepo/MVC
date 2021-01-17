package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDto;

public interface IEmployeeService {

	public List<EmployeeDto> fetchEmp();
	public String registerEmp(EmployeeDto dto);
	public List<Integer> fetchAllDept();
	public String removeEmp(int id);
	public EmployeeDto fetchEmpById(int id);
	public String modifyEmp(EmployeeDto dto);
}
