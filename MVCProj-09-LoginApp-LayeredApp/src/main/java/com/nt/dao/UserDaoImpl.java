package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserBo;

@Repository("dao")
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SimpleJdbcCall sjc;
	
	@Override
	public String authentication(UserBo bo) {
		
		sjc.setProcedureName("P_AUTHENTICATION");
		
		Map<String,Object> inParam=Map.of("UNAME",bo.getUname(),"UPWD",bo.getPwd());
		
		
		Map<String,Object> outParam=sjc.execute(inParam);
		String out =(String) outParam.get("RESULT");
		System.out.println(out);
		return out ;
	}

}
