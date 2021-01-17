package com.nt.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBo;

@Repository("dao")
public class EmployeeDaoImpl implements IEmployeeDao {
	
	private static final String GET_ALL_EMP="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";
	private static final String INSERT_EMP="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO) VALUES (ENO_SEQ.NEXTVAL,?,?,?,?)";
	private static final String GET_ALL_DEPT="SELECT DISTINCT DEPTNO FROM EMP WHERE DEPTNO IS NOT NULL ORDER BY DEPTNO";
	private static final String DELETE_BY_ID="DELETE FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_BY_ID="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	private static final String UPDATE_EMP="UPDATE EMP SET ENAME=?,JOB=?,SAL=?,DEPTNO=? WHERE EMPNO=?";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<EmployeeBo> getAllEmployee() {
		
		List<EmployeeBo> listBo = null;
		listBo=jt.query(GET_ALL_EMP, new ListEmployeeRowMapper());
		
		return listBo;
	}
	
	private class ListEmployeeRowMapper implements ResultSetExtractor<List<EmployeeBo>>{

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

	@Override
	public int saveEmp(EmployeeBo bo) {
		int count= 0;
		count =jt.update(INSERT_EMP,bo.getEname(),bo.getJob(),bo.getSal(),bo.getDeptNo());
		return count;
	}

	@Override
	public List<Integer> getAllDept() {
		List<Integer> deptNo= new ArrayList<>();
		List<Map<String,Object>> listMap = null;
		
		listMap=jt.queryForList(GET_ALL_DEPT);
		listMap.forEach(d->{
			deptNo.add((Integer)((BigDecimal)d.get("DEPTNO")).intValue());
		});
		return deptNo;
	}

	@Override
	public int deleteEmp(int id) {
		int count =0;
		
		count =jt.update(DELETE_BY_ID,id);
		return count;
	}

	@Override
	public EmployeeBo getEmpById(int id) {
		EmployeeBo bo = null;
		bo=jt.queryForObject(GET_EMP_BY_ID, new EmployeeRowMapper(), id);
		
			return bo;
		}
	
	private static class EmployeeRowMapper implements RowMapper<EmployeeBo>{

		@Override
		public EmployeeBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeBo bo = null;
			
			bo = new EmployeeBo();
			bo.setEmpNo(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getFloat(4));
			bo.setDeptNo(rs.getInt(5));
			
			return bo;
		}
		
	}

	@Override
	public int updateEmp(EmployeeBo bo) {
		int count =0;
		
		count =jt.update(UPDATE_EMP, 
						bo.getEname(),
						bo.getJob(),
						bo.getSal(),
						bo.getDeptNo(),
						bo.getEmpNo());
		return count;
	}


		
}
