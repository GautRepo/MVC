package com.nt.model;

import java.util.Arrays;
import java.util.Date;

public class Persion {
	
	private String name;
	private String addr;
	private String gender="female";
	private Long mobNo;
	private String[] hobbies = new String[] {"gaming","flurting"};
	private String qly="BE";
	private String[] color= new String[] {"red","white"};
	private Date dob,doj=new Date();
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getMobNo() {
		return mobNo;
	}
	public void setMobNo(Long mobNo) {
		this.mobNo = mobNo;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getQly() {
		return qly;
	}
	public void setQly(String qly) {
		this.qly = qly;
	}
	public String[] getColor() {
		return color;
	}
	public void setColor(String[] color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Persion [name=" + name + ", addr=" + addr + ", gender=" + gender + ", mobNo=" + mobNo + ", hobbies="
				+ Arrays.toString(hobbies) + ", qly=" + qly + ", color=" + Arrays.toString(color) + ", dob=" + dob
				+ ", doj=" + doj + "]";
	}
	
	
	
}
