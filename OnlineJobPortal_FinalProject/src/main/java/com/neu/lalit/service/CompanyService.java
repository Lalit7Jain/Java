package com.neu.lalit.service;

import com.neu.lalit.pojo.Company;


public interface CompanyService {

	public Long save(Company company);
	public void update(Company company);
	public Company getById(Long id);
	public Company getCompanybyEmail(String email);
	
}
