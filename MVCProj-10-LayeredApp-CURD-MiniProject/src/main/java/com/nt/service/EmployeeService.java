package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.EmployeeBo;
import com.nt.dao.IEmployeeDao;
import com.nt.dto.EmployeeDto;

@Service("service")
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public List<EmployeeDto> fetchEmp() {
		List<EmployeeBo> listBo= null;
		listBo=dao.getAllEmployee();
		List<EmployeeDto> listDto = new ArrayList<>();
		listBo.forEach(bo->{
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(bo, dto);
			dto.setSerialNo(listDto.size()+1);
			dto.setgSal(dto.getSal()+dto.getSal()*0.3f);
			dto.setnSal(dto.getgSal()-dto.getSal());
			listDto.add(dto);
		});
		
		return listDto;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public String registerEmp(EmployeeDto dto) {
		EmployeeBo bo = null;
		int count= 0;
		bo = new EmployeeBo();
		BeanUtils.copyProperties(dto, bo);
		count=dao.saveEmp(bo);
		return count==0?"Employee Registration Failed":"Employee Registration success";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public List<Integer> fetchAllDept() {
		
		return dao.getAllDept();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public String removeEmp(int id) {
		int count=0;
		
		count =dao.deleteEmp(id);
		return count==0?" employee with id "+id+" not found to delete":"employee with id "+id+" found and deleted";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public EmployeeDto fetchEmpById(int id) {
		EmployeeDto dto = null;
		EmployeeBo bo = null;
		
		dto =new EmployeeDto();
		bo=dao.getEmpById(id);
		BeanUtils.copyProperties(bo, dto);
		
		return dto;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public String modifyEmp(EmployeeDto dto) {
		int count =0;
		EmployeeBo bo =new EmployeeBo();
		
		BeanUtils.copyProperties(dto, bo);
		count=dao.updateEmp(bo);
		
		return count==0?"Updation of employee with id "+bo.getEmpNo()+" is failed":"Employee with id "+bo.getEmpNo()+" is successfuly updated";

	}

}
