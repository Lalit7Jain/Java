package com.neu.lalit.dao;

import java.util.List;

import org.hibernate.Session;

import com.neu.lalit.dto.UserApplication;
import com.neu.lalit.pojo.User;

public interface UserDao extends General<User, Long>{
	
	public User getByEmail(String email);
	public Session getSessionNow();
	public List<UserApplication> myApplication(Long userId);

}
