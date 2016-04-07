package com.neu.lalit.servimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neu.lalit.dao.ListingDao;
import com.neu.lalit.pojo.Listing;
import com.neu.lalit.service.ListingService;



@Service("listingService")
@Transactional
public class ListingServiceImp implements ListingService {

	@Autowired
	private ListingDao listingDao;

	public Long save(Listing listing) {
		return listingDao.save(listing);
	}

	public void update(Listing listing) {
		listingDao.update(listing);
	}

	public Listing getById(Long id) {
		return listingDao.getById(id);
	}

	@Override
	public List<Listing> getListing() {
		//List<Listing> listings = new ArrayList<Listing>();
		return listingDao.loadAll();
	}

	@Override
	public List<Listing> searchListing(String key) {
		return listingDao.searchListing(key);
	}

}
