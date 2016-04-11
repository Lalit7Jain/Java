package com.neu.lalit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.util.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.lalit.pojo.Company;
import com.neu.lalit.pojo.User;
import com.neu.lalit.service.UserService;

@Controller
public class AuthController {

	@Autowired
	UserService userservice;
	
	@RequestMapping(value = "/emplanding.htm", method = RequestMethod.GET)
	public ModelAndView empLanding(HttpServletRequest request){
		ModelAndView mav = null;
		HttpSession session = request.getSession();
		Company company = (Company)session.getAttribute("company");
		if(company == null){
			mav = new ModelAndView("emplanding");
		} else {
			mav = new ModelAndView("emplanding","company", company);
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/user/{id}/update.htm", method = RequestMethod.GET)
	public ModelAndView userUpdate(@PathVariable ("id") Long id){
		ModelAndView mav = null;
		User user = userservice.getById(id);
		mav = new ModelAndView("userupdateform","userupdate",user);
		
		return mav;
	}
	
	
}
