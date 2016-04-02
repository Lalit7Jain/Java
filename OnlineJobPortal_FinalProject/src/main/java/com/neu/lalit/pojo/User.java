package com.neu.lalit.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

//Using core concepts and interfaces of Spring Data repositories.
//Reference: http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html

@Entity
@Table(name="user")
public class User implements Serializable {
	
	//The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this number to ensure that a loaded class corresponds exactly to a serialized object.
	//If no match is found, then an InvalidClassException is thrown.
	private static final long serialVersionUID = 3646970822571242678L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true)
	@NotEmpty
	@Pattern(regexp= ".+@.+\\.[a-z]+")
	private String email;
	
	private String password;
	
	@NotNull
	@NotEmpty
	private String firstname;
	
	@NotNull
	@NotEmpty
	private String lastname;
	
	@NotNull
	@NotEmpty
	private String title;
	
	@Pattern(regexp = "[0-9]+")
	private String phone;
	
	private String countryid;
	private String role;
	private Boolean enabled = true;
	
	private Date registrationDate = new Date();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Application> applications;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<Resume> resumes;

	
	public User() {
		this.role = "ROLE_USER";
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getCountryid() {
		return countryid;
	}

	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public List<Resume> getResumes() {
		return resumes;
	}

	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}
	
	
	
	
	
	
}
