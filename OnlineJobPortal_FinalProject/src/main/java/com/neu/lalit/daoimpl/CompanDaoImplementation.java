package com.neu.lalit.daoimpl;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.neu.lalit.dao.CompanyDao;
import com.neu.lalit.dto.JobApplication;
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
	public List<JobApplication> getMyListing(Long compId) {
		//String hql = "from company c inner join c.listings";
//		String queryString = "select l.id, l.title, l.createDate, u.title, u.firstname, u.lastname, r.path, u.phone,u.email, u.registrationDate"
//				+ "From user u"
//				+ "Inner join resume r"
//				+ "on u.id = r.userId"
//				+ "Inner Join application a"
//				+ "on a.userId = u.id"
//				+ "inner join listing l"
//				+ "on a.listingId = l.id"
//				+ "inner join company c"
//				+ "on l.compId = c.id"
//				+ "where c.id = :companyId";
		List<JobApplication> listings = new ArrayList<JobApplication>();
		String queryString = "select l.id as JobID, l.title, l.createDate, u.title as UserTitle, u.firstname, u.lastname, r.path, u.phone,u.email, u.registrationDate "
				+ "From user u "
				+ "Inner join resume r "
				+ "on u.id = r.userId "
				+ "Inner Join application a "
				+ "on a.userId = u.id "
				+ "inner join listing l "
				+ "on a.listingId = l.id "
				+ "inner join company c "
				+ "on l.compId = c.id "
				+ "where c.id = " + compId;
		
		List list = this.sessionFactory.getCurrentSession().createSQLQuery(queryString).list();
		for(Object o : list){
			 JobApplication japp = new JobApplication();
			 Object[] obj = (Object[])o;
			 japp.setJobId((BigInteger) obj[0]);
			 japp.setTitle((String) obj[1]);
			 japp.setCreateDate((Timestamp) obj[2]);
			 japp.setFirstname((String) obj[4]);
			 japp.setLastname((String) obj[5]);
			 japp.setPath((String) obj[6]);
			 japp.setPhone((String) obj[7]);
			 japp.setEmail((String) obj[8]);
			 japp.setRegistrationDate((Timestamp) obj[9]);
			 listings.add(japp);			
		}
		
		return listings;
		
//		//Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
//		Query query2 = this.sessionFactory.getCurrentSession().createSQLQuery(queryString);
//		query2.setParameter("companyId", compId);
//		//List<Object[]> listResult = query2.list();
	
	}
}