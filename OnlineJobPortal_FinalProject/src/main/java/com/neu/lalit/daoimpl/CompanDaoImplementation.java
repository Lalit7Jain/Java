package com.neu.lalit.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.neu.lalit.dao.CompanyDao;
import com.neu.lalit.pojo.Company;
import com.neu.lalit.pojo.Listing;

@Repository
public class CompanDaoImplementation extends GenericDaoImplementation<Company, Long> implements CompanyDao {

	@SuppressWarnings("unchecked")
	public Company getByCompanyEmail(String email) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(persistentClass);
		
		criteria.add(Restrictions.eq("email", email));
		return (Company)DataAccessUtils.singleResult(criteria.list());	
		
		
		

}

	@Override
	public List<Listing> getMyListing() {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from company");
		return null;
	}
}