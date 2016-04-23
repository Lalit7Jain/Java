package com.neu.lalit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neu.lalit.pojo.Company;
import com.neu.lalit.pojo.Listing;
import com.neu.lalit.service.ListingService;

@Controller
@RequestMapping
public class CompanyOperations {

	
	@Autowired
	ListingService listingservice;
	
	@RequestMapping(value ="/managelisting.htm", method = RequestMethod.POST)
	public ModelAndView manageListings(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mav = null;
		HttpSession session = request.getSession();
		Company company = (Company)session.getAttribute("company");		
		Long compId = company.getId();
		
		List<Listing> companyListings = listingservice.companyListing(compId);
		
		mav = new ModelAndView("managelistings","managelistings",companyListings);
		
		return mav;
	}
	
	@RequestMapping(value ="/company/removelisting.htm", method = RequestMethod.GET)
	public @ResponseBody String removeListing(HttpServletRequest request, HttpServletResponse response){
		String result = "";
		Long listId = Long.parseLong(request.getParameter("listId"));
		
		if (listId == null || listId == 0 ) {
			result = "Found issue";
			return result;
		}
		
		Listing listing = listingservice.getById(listId);
		if(listing!= null){
			
			listingservice.deleteListing(listId);
			result = "SUCCESS";
		} else {
			result = "Found issue";
			return result;			
		}
		
		return result;
	}
	
	@RequestMapping(value="/company/{id}/updatelisting.htm", method = RequestMethod.GET)
	public ModelAndView updateListing(@PathVariable ("id") Long id, HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mav = null;
		HttpSession session = request.getSession();
		Company company = (Company)session.getAttribute("company");	
		List<Listing> companyListing = listingservice.companyListing(company.getId());
		
		Listing listing = listingservice.getById(id);		
		
		for(Listing l: companyListing){
			if(l.getId().equals(id)){
				mav= new ModelAndView("listingupdateform","listingupdate",listing);
				return mav;
			}
			
		}		
		
		return mav = new ModelAndView("listingupdateform");
	}
	
	@RequestMapping(value="/company/{id}/updatelisting.htm", method = RequestMethod.POST)
	public ModelAndView updatedListing(@PathVariable ("id") Long id, Listing listing, HttpServletRequest request, HttpServletResponse response){
		System.out.println("******************* updated listing");
		ModelAndView mav = null;
		HttpSession session = request.getSession();
		Company company = (Company)session.getAttribute("company");
		listing.setCompany(company);
		listingservice.update(listing);
		String message = "Updated Successfully";
		mav = new ModelAndView("listingupdateform","message",message);
		
		return mav;
	}

	
}
