package com.neu.lalit;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String listingJob(@ModelAttribute("companyListing") @Valid CompanyListing companyListing, BindingResult result,
			ModelMap model) {

		logger.debug("ListingController#working");

		// Check if there is any Binding error
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println("Object name: " + error.getObjectName());
				System.out.println("Arguments : " + error.getArguments());
				System.out.println("Default message : " + error.getDefaultMessage());
			}
			model.put("companyListing", companyListing);
			return "postjob";
		}

		Company company = companyService.getCompanyName(companyListing.getName());
		if (company == null) {

			Company newcompany = companyListing.getCompany();
			Long compId = companyService.save(newcompany);

			Listing newListing = companyListing.getListing();
			newListing.setCompany(newcompany);
			listingService.save(newListing);

			model.addAttribute("listingSucess", true);
			model.addAttribute("listingname", newListing.getTitle());
			return "postjob";

		} else {
			model.addAttribute("companyListing", companyListing);
			return "postjob";

		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("companyListing") CompanyListing companyListing, BindingResult result)
			throws Exception {
		return "postjob";
	}

}
