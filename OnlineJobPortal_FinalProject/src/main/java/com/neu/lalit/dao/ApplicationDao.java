package com.neu.lalit.dao;



import com.neu.lalit.pojo.Application;

public interface ApplicationDao extends General<Application, Long> {

	public Long getnoofApplications(Long listingid);
}
