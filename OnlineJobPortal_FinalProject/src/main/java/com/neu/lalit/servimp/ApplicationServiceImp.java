package com.neu.lalit.servimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neu.lalit.dao.ApplicationDao;
import com.neu.lalit.pojo.Application;
import com.neu.lalit.service.ApplicationService;

@Service("applicationService")
@Transactional 
public class ApplicationServiceImp implements ApplicationService {

	@Autowired
	ApplicationDao applicationdao;
	
	@Override
	public Long save(Application application) {
		return applicationdao.save(application);
	}

	@Override
	public Application getById(Long id) {
		return applicationdao.getById(id);
	}

	@Override
	public List<Application> getApplication() {
		return applicationdao.loadAll();
	}

	@Override
	public void deleteApplication(Long id) {
		applicationdao.deleteById(id);
		
	}

}
