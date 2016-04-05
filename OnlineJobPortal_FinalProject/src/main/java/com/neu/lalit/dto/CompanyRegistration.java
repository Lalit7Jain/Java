package com.neu.lalit.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.neu.lalit.pojo.Company;

public class CompanyRegistration {

	
	@NotNull
	@NotEmpty
	private String name;
	
	@NotEmpty
	@Email
	//@Pattern(regexp = ".+@.+\\.[a-z]+")
	private String email;

	@Size(min=8)	
	private String password;
	
	@Size(min=8)
	private String confirmPassword;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public Company getCompany(){
		Company c = new Company();
		c.setEmail(this.email);
		c.setName(this.name);
		c.setPassword(this.password);
		return c;		
	}
	
}
