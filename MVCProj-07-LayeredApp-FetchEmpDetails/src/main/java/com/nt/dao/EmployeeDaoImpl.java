package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBo;

@Repository("dao")
public class EmployeeDaoImpl implements IEmployeeDao {
	
	private static final String GET_ALL_EMP="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";

	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<EmployeeBo> getAllEmployee() {
		
		List<EmployeeBo> listBo = null;
		listBo=jt.query(GET_ALL_EMP, new EmployeeRowMapper());
		
		return listBo;
	}
	
	private class EmployeeRowMapper implements ResultSetExtractor<List<EmployeeBo>>{

		@Override
		public List<EmployeeBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBo> listBo =new ArrayList<>();
			
			while(rs.next()) {
				EmployeeBo bo = new EmployeeBo();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				bo.setDeptNo(rs.getInt(5));
				listBo.add(bo);
			}
			return listBo;
		}
		
	}

}
