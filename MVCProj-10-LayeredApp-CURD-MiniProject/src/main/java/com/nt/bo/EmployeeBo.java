package com.nt.bo;

public class EmployeeBo {
	private int empNo;
	private String ename;
	private String job;
	private Float sal;
	private int deptNo;
	
	
	public int getEmpNo() {
		return empNo;
	}


	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}
	public Float getSal() {
		return sal;
	}


	public void setSal(Float sal) {
		this.sal = sal;
	}


	


	public int getDeptNo() {
		return deptNo;
	}


	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}


	@Override
	public String toString() {
		return "EmployeeBo [empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", deptNo="
				+ deptNo + "]";
	}
	
	

}
