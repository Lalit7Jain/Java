package com.neu.lalit.service;

import java.util.List;

import com.neu.lalit.pojo.Application;

public interface ApplicationService {

	public Long save(Application application);
	public Application getById(Long id);
	public List<Application> getApplication();

	public void deleteApplication(Long id);
	public Long getnoofApplications(Long listingid);
}
