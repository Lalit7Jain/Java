package com.neu.lalit.service;

import java.util.List;

import com.neu.lalit.pojo.Company;
import com.neu.lalit.pojo.Listing;


public interface CompanyService {

	public Long save(Company company);
	public void update(Company company);
	public Company getById(Long id);
	public Company getCompanybyEmail(String email);
	
	
}
