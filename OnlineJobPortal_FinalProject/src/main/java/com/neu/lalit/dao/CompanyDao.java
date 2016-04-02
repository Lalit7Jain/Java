package com.neu.lalit.dao;

import com.neu.lalit.pojo.Company;

public interface CompanyDao extends General<Company, Long> {

	public Company getByCompanyName(String name);
	
}
