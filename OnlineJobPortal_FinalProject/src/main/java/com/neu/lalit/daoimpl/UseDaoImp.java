package com.neu.lalit.daoimpl;


import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.neu.lalit.dao.UserDao;
import com.neu.lalit.pojo.User;


@Repository
public class UseDaoImp extends GenericDaoImplementation<User, Long> implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public User getByEmail(String email) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(persistentClass);
		
		//only get results matching the email id;
		criteria.add(Restrictions.eq("email", email));
		
		//Using DataAccessUtils spring API to get single result from the criteria list and casting to User type
		return (User)DataAccessUtils.singleResult(criteria.list());
	}
	

}
