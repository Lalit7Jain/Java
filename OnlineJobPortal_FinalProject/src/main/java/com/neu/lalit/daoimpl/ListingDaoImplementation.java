package com.neu.lalit.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Repository;

import com.neu.lalit.dao.ListingDao;
import com.neu.lalit.pojo.Listing;

@Repository
public class ListingDaoImplementation extends GenericDaoImplementation<Listing, Long> implements ListingDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Listing> searchListing(String key) {
		List<Listing> newList = new ArrayList<Listing>();
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(persistentClass);

		criteria.add(Restrictions.ilike("title", "%key%"));
		newList = criteria.list();
		return newList;

	}

}
