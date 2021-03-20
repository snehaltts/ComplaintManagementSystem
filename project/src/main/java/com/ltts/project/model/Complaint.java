package com.ltts.project.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Complaint implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String complaintDescription;
	private String complaintIncharge;
	private String complaintSubject;
	private String complaintType;
	private String requestStatus;
	private Date date;
	private String empid;
	
	@Id
	@GeneratedValue
	private String comid;

	public Complaint() {
		super();
	}

	public Complaint(String complaintDescription, String complaintIncharge, String complaintSubject, String complaintType, String requestStatus, Date date, String empid, String comid) 
	{
		super();
		this.complaintDescription = complaintDescription;
		this.complaintIncharge = complaintIncharge;
		this.complaintSubject = complaintSubject;
		this.complaintType = complaintType;
		this.requestStatus = requestStatus;
		this.date = date;
		this.empid = empid;
		this.comid = comid;
	}

	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	public String getComplaintIncharge() {
		return complaintIncharge;
	}

	public void setComplaintIncharge(String complaintIncharge) {
		this.complaintIncharge = complaintIncharge;
	}

	public String getComplaintSubject() {
		return complaintSubject;
	}

	public void setComplaintSubject(String complaintSubject) {
		this.complaintSubject = complaintSubject;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	@Override
	public String toString() {
		return "Complaint [complaintDescription=" + complaintDescription + ", complaintIncharge=" + complaintIncharge
				+ ", complaintSubject=" + complaintSubject + ", complaintType=" + complaintType + ", requestStatus="
				+ requestStatus + ", date=" + date + ", empid=" + empid +", comid=" + comid + "]";
	}
	
}	