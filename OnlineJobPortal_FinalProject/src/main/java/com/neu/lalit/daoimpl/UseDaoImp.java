package com.neu.lalit.daoimpl;


import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.neu.lalit.dao.UserDao;
import com.neu.lalit.dto.UserApplication;
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

	@Override
	public Session getSessionNow() {
		return this.getSession();
	}

	@Override
	public List<UserApplication> myApplication(Long userId) {
		List<UserApplication> listings = new ArrayList<UserApplication>();
		String querystring = "select a.id as AppId, c.name, l.id, l.title, l.createDate, l.salary "
				+ "From user u "
				+ "Inner Join application a "
				+ "on a.userId = u.id "
				+ "inner join listing l "
				+ "on a.listingId = l.id "
				+ "inner join company c "
				+ "on l.compId = c.id "
				+ "where u.id = " + userId;
		
		List list = this.sessionFactory.getCurrentSession().createSQLQuery(querystring).list();
		for(Object o : list){
			 UserApplication japp = new UserApplication();
			 Object[] obj = (Object[])o;
			 japp.setAppId((BigInteger) obj[0]);
			 japp.setName((String)obj[1]) ;
			 japp.setJobId((BigInteger) obj[2]);
			 japp.setTitle((String) obj[3]);
			 japp.setCreateDate((Timestamp) obj[4]);
			 japp.setSalary((Integer) obj[5]);
			 listings.add(japp);			
		}
		return listings;
		
		
	}
	

}
