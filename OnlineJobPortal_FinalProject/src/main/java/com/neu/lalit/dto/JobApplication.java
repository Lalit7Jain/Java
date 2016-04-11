package com.neu.lalit.dto;

import java.math.BigInteger;
import java.sql.Timestamp;


public class JobApplication {

	private BigInteger jobId;
	private String title;
	private Timestamp createDate;
	private String firstname;
	private String lastname;
	private String path;
	private String email;
	private String phone;
	private Timestamp registrationDate;
	
	
	public BigInteger getJobId() {
		return jobId;
	}
	public void setJobId(BigInteger jobId) {
		this.jobId = jobId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
	
}
