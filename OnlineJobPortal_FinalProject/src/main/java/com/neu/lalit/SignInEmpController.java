package com.neu.lalit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.neu.lalit.pojo.Company;
import com.neu.lalit.service.CompanyService;

@Controller
@RequestMapping(value = "/empsignin.htm")
public class SignInEmpController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	CompanyService companyservice;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView executeSignIn(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("company") Company company, BindingResult result) {
		HttpSession httpSession = request.getSession(true);
		ModelAndView mav = null;

		logger.debug("SignInEmpController#executeSignin() working");

		// Check if there is any Binding error
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println("Object name: " + error.getObjectName());
				System.out.println("Arguments : " + error.getArguments());
				System.out.println("Default message : " + error.getDefaultMessage());
			}
			mav.addObject("comapany",company);
			mav = new ModelAndView("empsignin");
		}

		Company newcompany = companyservice.getCompanybyEmail(company.getEmail());
		if (!(newcompany == null)) {
			if (newcompany.getEmail().equals(company.getEmail())
					&& newcompany.getPassword().equals(company.getPassword())) {
				httpSession.setAttribute("company", newcompany);
				mav = new ModelAndView("emplanding");
				
			} else {
				request.setAttribute("message", "UserName or Password you entered does not match! Try again");
				System.out.println("*** Company was not authenticated.");
				mav = new ModelAndView("empsignin","company",company);
			}

		} else {
			request.setAttribute("message", "UserName or Password you entered does not match! Try again");
			System.out.println("*** Company was not authenticated.");
			mav = new ModelAndView("empsignin","company",company);
		}
		
		
		
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("company") Company company, BindingResult result) throws Exception {
		return "empsignin";
	}

}
