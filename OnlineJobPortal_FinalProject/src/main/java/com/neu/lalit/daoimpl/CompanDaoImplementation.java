package com.neu.lalit.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.neu.lalit.dao.CompanyDao;
import com.neu.lalit.pojo.Company;

@Repository
public class CompanDaoImplementation extends GenericDaoImplementation<Company, Long> implements CompanyDao {

	@SuppressWarnings("unchecked")
	public Company getByCompanyName(String name) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(persistentClass);
		
		criteria.add(Restrictions.eq("name", name));
		return (Company)DataAccessUtils.singleResult(criteria.list());	

}
}