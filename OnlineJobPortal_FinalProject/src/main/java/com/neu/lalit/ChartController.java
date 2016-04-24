package com.neu.lalit;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.lalit.dto.ChartModel;
import com.neu.lalit.pojo.Company;
import com.neu.lalit.pojo.Listing;
import com.neu.lalit.service.ApplicationService;
import com.neu.lalit.service.ListingService;

@Controller
@RequestMapping(value="/chart/applications.htm")
public class ChartController {
	
	@Autowired
	ListingService listingservice;
	
	@Autowired
	ApplicationService applicationservice;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody List<ChartModel> getApplicationChart(HttpServletRequest request){
		
		List<ChartModel> applicationList = new ArrayList<ChartModel>();
		HttpSession session = request.getSession();
		Company com = (Company)session.getAttribute("company");
		
		List<Listing> compListing = listingservice.companyListing(com.getId());
		
		for(Listing l: compListing){
			ChartModel cm = new ChartModel();
			cm.setTitle(l.getTitle());
			Long count = applicationservice.getnoofApplications(l.getId());
			cm.setNoofapplications(String.valueOf(count));
			applicationList.add(cm);
		}
		
		return applicationList;
	}
}
