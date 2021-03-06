package com.neu.lalit.servimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.neu.lalit.dao.CompanyDao;
import com.neu.lalit.dto.JobApplication;
import com.neu.lalit.pojo.Company;
import com.neu.lalit.pojo.Listing;
import com.neu.lalit.service.CompanyService;

@Service("companyService")
@Transactional
public class CompanyServiceImp implements CompanyService {

	@Autowired
	CompanyDao companyDao;

	@Override
	public Long save(Company company) {
		return companyDao.save(company);
	}

	@Override
	public void update(Company company) {
		companyDao.update(company);

	}

	@Override
	public Company getById(Long id) {
		return companyDao.getById(id);
	}

	@Override
	public Company getCompanybyEmail(String email) {
		return companyDao.getByCompanyEmail(email);
	}

	@Override
	public List<JobApplication> getmyListing(Long compId) {
		return companyDao.getMyListing(compId);
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyDao.loadAll();
	}

	

}
