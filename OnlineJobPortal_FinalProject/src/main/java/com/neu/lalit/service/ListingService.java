package com.neu.lalit.service;

import java.util.List;

import com.neu.lalit.pojo.Listing;

public interface ListingService {

	public Long save(Listing listing);
	public void update(Listing listing);
	public Listing getById(Long id);
	public List<Listing> getListing();
	public List<Listing> searchListing(String key);
	public List<Listing> companyListing(Long id);
	public void deleteListing(Long id);
}
