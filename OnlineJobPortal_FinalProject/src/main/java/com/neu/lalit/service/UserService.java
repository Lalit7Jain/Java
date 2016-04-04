package com.neu.lalit.service;

import com.neu.lalit.pojo.User;

public interface UserService {
	
	public Long save(User user);
	public User getById(Long id);
	public void update(User user);
	public User getMe();
	public User getByEmail(String email);
	
}