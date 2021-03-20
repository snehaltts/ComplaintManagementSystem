package com.ltts.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String empName;
	private String password;
	private String desig;
	private String department;
	private String immediatesupervisor;
	private String email;
	private String mobile;
	@Id
	private String empid;
	
	public Member() {
		super();
	}

	
	public Member(String empName, String password, String desig, String department, String immediatesupervisor, String email, String mobile, String empid) {
		super();
		this.empName = empName;
		this.password = password;
		this.desig = desig;
		this.department = department;
		this.immediatesupervisor = immediatesupervisor;
		this.email = email;
		this.mobile = mobile;
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getImmediatesupervisor() {
		return immediatesupervisor;
	}

	public void setImmediatesupervisor(String immediatesupervisor) {
		this.immediatesupervisor = immediatesupervisor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Member [empName=" + empName + ", password=" + password + ", desig=" + desig + ", department="
				+ department + ", immediatesupervisor=" + immediatesupervisor + ", email=" + email + ", mobile="
				+ mobile + ", empid=" + empid + "]";
	}



}	