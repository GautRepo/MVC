package com.nt.dto;

import java.io.Serializable;


public class EmployeeDto implements Serializable{
	private int serialNo;
	private int empNo;
	private String ename;
	private String job;
	private Float sal;
	private int deptNo;
	private float gSal;
	private float nSal;
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
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
	public float getgSal() {
		return gSal;
	}
	public void setgSal(float gSal) {
		this.gSal = gSal;
	}
	public float getnSal() {
		return nSal;
	}
	public void setnSal(float nSal) {
		this.nSal = nSal;
	}
	@Override
	public String toString() {
		return "EmployeeDto [serialNo=" + serialNo + ", empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", sal="
				+ sal + ", deptNo=" + deptNo + ", gSal=" + gSal + ", nSal=" + nSal + "]";
	}
	
	

}
