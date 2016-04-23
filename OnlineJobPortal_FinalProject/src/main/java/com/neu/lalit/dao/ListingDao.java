package com.neu.lalit.dao;

import java.util.List;

import com.neu.lalit.pojo.Listing;

public interface ListingDao extends General<Listing, Long> {

	public List<Listing> searchListing(String key);
	public List<Listing> companyListing(Long id);
	
}
