package com.neu.lalit.service;

import java.util.List;

import com.neu.lalit.dto.JobApplication;
import com.neu.lalit.pojo.Company;



public interface CompanyService {

	public Long save(Company company);
	public void update(Company company);
	public Company getById(Long id);
	public Company getCompanybyEmail(String email);
	public List<JobApplication> getmyListing(Long compId);
	
}
