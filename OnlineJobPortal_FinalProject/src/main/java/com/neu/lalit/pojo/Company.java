package com.neu.lalit.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="company")
public class Company implements Serializable {
	
	private static final long serialVersionUID = 2517818741423059466L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true)
	@NotEmpty
	@Pattern(regexp= ".+@.+\\.[a-z]+")
	private String email;
	
	private String password;
	
	@NotEmpty
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private List<Listing> listings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Listing> getListings() {
		return listings;
	}

	public void setListings(List<Listing> listings) {
		this.listings = listings;
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

		
}
