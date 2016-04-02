package com.neu.lalit.dao;

import com.neu.lalit.pojo.User;

public interface UserDao extends General<User, Long>{
	
	public User getByEmail(String email);
	

}
