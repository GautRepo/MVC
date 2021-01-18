package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBo;
import com.nt.dao.IEmployeeDao;
import com.nt.dto.EmployeeDto;

@Service("service")
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao dao;

	@Override
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

}
