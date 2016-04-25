package com.neu.lalit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neu.lalit.pojo.Company;
import com.neu.lalit.pojo.Listing;
import com.neu.lalit.pojo.User;
import com.neu.lalit.service.CompanyService;
import com.neu.lalit.service.ListingService;

@Controller
@RequestMapping(value = "/searchresult.htm")
public class SearchController {

	@Autowired
	ListingService listingservice;
	
	@Autowired
	CompanyService companyservice;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView searchResult(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;

		String key = request.getParameter("text");
		System.out.println("**************** Ajax Call made to controller key + different &&& found: " + key);
		if (key == null) {

			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			request.setAttribute("message", "You must enter values to search");
			mav = new ModelAndView("userlanding", "user", user);
		} else {
			System.out.println("********* Went into list");
			ArrayList<String> compname = new ArrayList<String>();
			//List<Listing> listingList = listingservice.getListing();
			List<Listing> listingList = listingservice.searchListing(key);
			
			for(Listing l: listingList){
				compname.add(listingservice.getCompanyname(l.getId()));
			}
			
			mav = new ModelAndView("userlanding", "listing", listingList);
			mav.addObject("compname", compname);
		}

		return mav;

	}

	
//	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
//	@ResponseBody
//	public List<Listing> search(HttpServletRequest request, HttpServletResponse response) {
//
//		ModelAndView mav = null;
//
//		String key = request.getParameter("key");
//		System.out.println("**************** Ajax Call made to controller key + different &&& found: " + key);
//		if (key == null) {
//
//			HttpSession session = request.getSession();
//			User user = (User) session.getAttribute("user");
//			request.setAttribute("message", "You must enter values to search");
//			mav = new ModelAndView("searchjob", "user", user);
//		}
//		List<Listing> listingList = listingservice.getListing();
//
//		System.out.println("*******************" + listingList);
//		// List<Listing> listingList = listingservice.searchListing(key);
//
//		return listingList;

//	}
	
	
	// @RequestMapping(method = RequestMethod.GET, produces="application/json")
	// @ResponseBody
	// public ModelAndView searchResult(HttpServletRequest request,
	// HttpServletResponse response) {
	//
	// ModelAndView mav = null;
	//
	// String key = request.getParameter("key");
	// System.out.println("**************** Ajax Call made to controller key
	// found: " + key);
	// if (key == null) {
	//
	// HttpSession session = request.getSession();
	// User user = (User) session.getAttribute("user");
	// request.setAttribute("message", "You must enter values to search");
	// mav = new ModelAndView("searchjob", "user", user);
	// } else {
	// List<Listing> listingList = listingservice.getListing();
	//
	// System.out.println("*******************"+ listingList);
	// //List<Listing> listingList = listingservice.searchListing(key);
	//
	// JSONObject json = new JSONObject();
	// try {
	// json.put("listings", listingList);
	// response.setContentType("application/json;charset=UTF-8");
	// PrintWriter out = response.getWriter();
	// out.println(json);
	//
	// } catch (JSONException e) {
	// System.out.println("********** Exception in getting the list and putting
	// into JSON Object");
	// e.printStackTrace();
	// } catch (IOException e) {
	// System.out.println("********** Exception in writing the object to JSON
	// using PrintWriter");
	// e.printStackTrace();
	// }
	//
	// }
	//
	// return mav;
	// }
	//

}
