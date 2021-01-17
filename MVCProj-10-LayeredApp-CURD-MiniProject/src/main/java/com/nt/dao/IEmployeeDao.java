package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBo;

public interface IEmployeeDao {
	
	public List<EmployeeBo> getAllEmployee();
	public int saveEmp(EmployeeBo bo);
	public List<Integer> getAllDept();
	public int deleteEmp(int id);
	public EmployeeBo getEmpById(int id);
	public int updateEmp(EmployeeBo bo);

}
