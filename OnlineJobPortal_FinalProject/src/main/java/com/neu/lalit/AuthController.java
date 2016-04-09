package com.neu.lalit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.lalit.pojo.Company;

@Controller
@RequestMapping(value = "/emplanding.htm")
public class AuthController {

	
	@RequestMapping(method = RequestMethod.GET)
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
}
