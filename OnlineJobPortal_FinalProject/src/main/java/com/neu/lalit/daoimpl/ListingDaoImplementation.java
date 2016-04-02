package com.neu.lalit.daoimpl;

import org.springframework.stereotype.Repository;

import com.neu.lalit.dao.ListingDao;
import com.neu.lalit.pojo.Listing;

@Repository
public class ListingDaoImplementation extends GenericDaoImplementation<Listing, Long> implements ListingDao{

}
