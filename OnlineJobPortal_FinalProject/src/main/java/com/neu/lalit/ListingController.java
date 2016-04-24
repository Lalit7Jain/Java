package com.neu.lalit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.lalit.dto.CompanyListing;
import com.neu.lalit.pojo.Company;
import com.neu.lalit.pojo.Listing;
import com.neu.lalit.service.CompanyService;
import com.neu.lalit.service.ListingService;

@Controller
@RequestMapping(value = "/postjob.htm")
public class ListingController {

	private static final Logger logger = Logger.getLogger(ListingController.class);

	@Autowired
	CompanyService companyService;

	@Autowired
	ListingService listingService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView jobPost(@ModelAttribute("companyListing") @Valid CompanyListing companyListing, BindingResult result, HttpServletRequest request ){
	
		ModelAndView mav = null;
		
		
		logger.debug("ListingController#working");

		// Check if there is any Binding error
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println("Object name: " + error.getObjectName());
				System.out.println("Arguments : " + error.getArguments());
				System.out.println("Default message : " + error.getDefaultMessage());
			}
			mav = new ModelAndView("postjob","companyListing", companyListing);
			return mav;
		}
		
		HttpSession session = request.getSession();
		Company company = (Company)session.getAttribute("company");		
		
		if(!(company == null)){
		
			Listing newListing = companyListing.getListing();
			newListing.setCompany(company);
			listingService.save(newListing);		
			mav = new ModelAndView("postjob","listingname",newListing);
			
		} else {
			
			mav = new ModelAndView("postjob","companyListing", companyListing);
			return mav;
		}
		
		return mav;
	}
	


	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("companyListing") CompanyListing companyListing, BindingResult result)
			throws Exception {
		return "postjob";
	}

}
