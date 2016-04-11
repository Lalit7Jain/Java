package com.neu.lalit.dao;

import org.hibernate.Session;

import com.neu.lalit.pojo.User;

public interface UserDao extends General<User, Long>{
	
	public User getByEmail(String email);
	public Session getSessionNow();

}
