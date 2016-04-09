package com.neu.lalit;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.lalit.dto.JobApplication;
import com.neu.lalit.pojo.Application;
import com.neu.lalit.pojo.Company;
import com.neu.lalit.pojo.Listing;
import com.neu.lalit.pojo.User;
import com.neu.lalit.service.ApplicationService;
import com.neu.lalit.service.CompanyService;
import com.neu.lalit.service.ListingService;
import com.neu.lalit.service.UserService;

@Controller
@RequestMapping(value = "/checkappstatus.htm")
public class CompanyApplicationStatus {

	@Autowired
	UserService userservice;

	@Autowired
	ListingService listingservice;

	@Autowired
	CompanyService companyservice;

	@Autowired
	ApplicationService applicationservice;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView checkStatus(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		System.out.println("************** Into Controller");
		ArrayList<JobApplication> listOfApplication = new ArrayList<JobApplication>();

		
		Long compId = Long.parseLong(request.getParameter("compId"));

		if(!(compId == null && compId == 0)){
			System.out.println("************** Into loop");
		Company newcompany = (Company) companyservice.getById(compId);
		List<Application> allApplication = applicationservice.getApplication();
		List<User> allUser = userservice.getAllUser();
		List<Listing> allListing = listingservice.getListing();

		for (Listing l : allListing) {
			if (l.getCompany().equals(newcompany)) {
				JobApplication japp = new JobApplication();
				japp.setJobId(String.valueOf(l.getId()));
				japp.setTitle(l.getTitle());
				japp.setCreateDate(String.valueOf(l.getCreateDate()));
				for (Application a : allApplication) {
					if (a.getListing().equals(l)) {
						for (User u : allUser) {
							if (a.getUser().equals(u)) {
								japp.setFirstname(u.getFirstname());
								japp.setLastname(u.getLastname());
								japp.setPhone(u.getPhone());
								japp.setEmail(u.getEmail());

							}

						}

					}
				}
				listOfApplication.add(japp);
				System.out.println("************** Added Application");
			}
		}
		
		mav = new ModelAndView("checkappstatus","listofapplication",listOfApplication);

		
	} else {
		System.out.println("Something went wrong");
		mav = new ModelAndView("checkappstatus");
	}
	
		return mav;

}
}
