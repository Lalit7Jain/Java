package com.neu.lalit.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.neu.lalit.dao.ApplicationDao;
import com.neu.lalit.pojo.Application;

@Repository
public class ApplicationDaoImplementation extends GenericDaoImplementation<Application, Long> implements ApplicationDao{

	@Override
	public Long getnoofApplications(Long listingid) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(persistentClass);
		Criteria listCrit = criteria.createCriteria("listing");
		listCrit.add(Restrictions.eq("id", listingid));
		criteria.setProjection(Projections.count("id"));
		Long result = (Long) criteria.uniqueResult();
		return result;
	}

	
	
	
}
