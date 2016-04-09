package com.neu.lalit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.lalit.pojo.Application;
import com.neu.lalit.pojo.Listing;
import com.neu.lalit.pojo.User;
import com.neu.lalit.service.ApplicationService;
import com.neu.lalit.service.ListingService;
import com.neu.lalit.service.UserService;

@Controller
@RequestMapping(value = "/applyJob.htm")
public class UserJobApplication {

	@Autowired
	ListingService listingService;

	@Autowired
	ApplicationService applicationService;

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)

	public @ResponseBody String userJobApplication(HttpServletRequest request, HttpServletResponse response) {
		String result = "";
		String action = request.getParameter("action");

		if (action.equals("apply")) {
			Long listId = Long.parseLong(request.getParameter("listId"));
			Long userId = Long.parseLong(request.getParameter("userId"));

			if (listId == null || userId == null) {
				result = "Found issue";
				return result;
			}

			Listing listing = listingService.getById(listId);
			User user = userService.getById(userId);

			if (listing == null || user == null) {
				result = "No such User or Listing found";
				return result;
			} else {

				Application application = new Application();
				application.setListing(listing);
				application.setUser(user);
				Long val = applicationService.save(application);
				System.out.println("************** Application submitted sucessfully with App ID: " + val) ;
				result = "SUCCESS";
			}
		}
		return result;

	}

}
