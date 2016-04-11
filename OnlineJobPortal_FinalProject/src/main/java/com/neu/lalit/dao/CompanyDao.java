package com.neu.lalit.dao;

import java.util.List;

import com.neu.lalit.dto.JobApplication;
import com.neu.lalit.pojo.Company;

public interface CompanyDao extends General<Company, Long> {

	public Company getByCompanyEmail(String email);
	
	public List<JobApplication> getMyListing(Long compId);
	
}
