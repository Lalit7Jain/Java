package com.neu.lalit.servimp;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neu.lalit.dao.UserDao;
import com.neu.lalit.dto.UserApplication;
import com.neu.lalit.pojo.User;
import com.neu.lalit.service.UserService;


//Using service later for making operations and using Spring Transactional which will take care of Commit and rollback automati
@Service("userService")
@Transactional 
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userdao;

	public Long save(User user) {
		return userdao.save(user);		
		
	}

	public User getById(Long id) {
		return userdao.getById(id);
	}
	
	public void update(User user) {
		userdao.update(user);
		
	}
	
	//Using Spring Security to get the current principal(User)
	public User getMe() {
		return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public User getByEmail(String email) {
		return userdao.getByEmail(email);
	}

	@Override
	public List<User> getAllUser() {
		
		return userdao.loadAll();
		
	}

	@Override
	public Session getSessionNow() {
		
		return userdao.getSessionNow();
	}

	@Override
	public List<UserApplication> myApplication(Long userId) {
		
		return userdao.myApplication(userId);
	}


}
