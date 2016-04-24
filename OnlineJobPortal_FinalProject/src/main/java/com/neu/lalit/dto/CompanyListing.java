package com.neu.lalit.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.neu.lalit.pojo.Company;
import com.neu.lalit.pojo.Listing;


public class CompanyListing {
	
	//use notEmpty hibernate validator for String types, and for Integer use only @NotNull of JSR303 validator
	
	@NotNull
	@NotEmpty
	private String name;
	
	@NotNull
	@NotEmpty
	private String title;	
	
	@NotNull
	@NotEmpty
	@Size(max = 5000)
	private String description;
	
	@NotNull
	private Integer salary;
	
	@NotNull
	private Integer cityId;
	
	@NotNull
	private Integer townId;
	
	@NotNull
	@NotEmpty
	@Email
	private String contactEmail;
	
	@NotNull
	@NotEmpty
	private String contactName;	
	
	@Pattern(regexp = "[0-9]+")
	private String contactPhone;
	
	@NotNull
	private Integer type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getTownId() {
		return townId;
	}

	public void setTownId(Integer townId) {
		this.townId = townId;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	public Company getCompany(){
		Company c = new Company();
		c.setName(this.name);
		return c;
	}
	
	public Listing getListing(){
		Listing l = new Listing();
		l.setCityId(this.cityId);
		l.setContactEmail(this.contactEmail);
		l.setContactName(this.contactName);
		l.setContactPhone(this.contactPhone);		
		l.setDescription(this.description);
		l.setSalary(this.salary);
		l.setTitle(this.title);
		l.setTownId(this.townId);
		l.setType(this.type);
		return l;
		
	}
	
	
	
	
}
