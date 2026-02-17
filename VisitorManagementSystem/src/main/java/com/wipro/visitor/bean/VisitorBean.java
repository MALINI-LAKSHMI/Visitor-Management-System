package com.wipro.visitor.bean;

import java.util.Date;

public class VisitorBean {
	private String visitorId;
	private String visitorName;
	private String purpose;
	private java.sql.Date visitDate;
	private String contactNo;
	private String remarks;
	public String getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(String visitorId) {
		this.visitorId = visitorId;
	}
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public java.sql.Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date date) {
		this.visitDate = (java.sql.Date) date;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
