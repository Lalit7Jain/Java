package com.neu.lalit.servimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neu.lalit.dao.ResumeDao;
import com.neu.lalit.pojo.Resume;
import com.neu.lalit.service.ResumeService;



@Service("resumeService")
@Transactional
public class ResumeServiceImp implements ResumeService {
	@Autowired
	private ResumeDao resumeDao;

	@Override
	public Long save(Resume resume) {
		return resumeDao.save(resume);
	}

	@Override
	public void update(Resume resume) {
		resumeDao.update(resume);
	}

	@Override
	public Resume getById(Long id) {
		return resumeDao.getById(id);
	}

}
