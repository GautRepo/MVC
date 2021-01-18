package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.UserBo;
import com.nt.dao.IUserDao;
import com.nt.dto.UserDto;

@Service("service")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public String login(UserDto dto) {
		UserBo bo = null;
		String result = null;
		
		bo= new UserBo();
		BeanUtils.copyProperties(dto, bo);
		result=dao.authentication(bo);
		
		return result;
	}

}
