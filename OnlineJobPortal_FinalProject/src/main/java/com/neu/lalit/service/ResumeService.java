package com.neu.lalit.service;

import com.neu.lalit.pojo.Resume;

public interface ResumeService {

	public Long save(Resume resume);
	public void update(Resume resume);
	public Resume getById(Long id);
}
