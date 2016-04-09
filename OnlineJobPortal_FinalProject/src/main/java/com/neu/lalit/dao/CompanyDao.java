package com.neu.lalit.dao;

import java.util.List;

import com.neu.lalit.pojo.Company;
import com.neu.lalit.pojo.Listing;

public interface CompanyDao extends General<Company, Long> {

	public Company getByCompanyEmail(String email);
	
	public List<Listing> getMyListing();
	
}
