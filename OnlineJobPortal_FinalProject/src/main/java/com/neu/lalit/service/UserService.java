package com.neu.lalit.service;

import java.util.List;

import org.hibernate.Session;

import com.neu.lalit.dto.UserApplication;
import com.neu.lalit.pojo.User;

public interface UserService {
	
	public Long save(User user);
	public User getById(Long id);
	public void update(User user);
	public User getMe();
	public User getByEmail(String email);
	public List<User> getAllUser();
	public Session getSessionNow();
	public List<UserApplication> myApplication(Long userId);
	
}
