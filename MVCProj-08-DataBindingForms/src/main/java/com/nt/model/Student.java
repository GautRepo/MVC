package com.nt.model;

public class Student {
	
	private Integer serialNo;
	private String sname;
	private String sadd;
	private String hobby;
	public Integer getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "Student [serialNo=" + serialNo + ", sname=" + sname + ", sadd=" + sadd + ", hobby=" + hobby + "]";
	}
	
	

}
