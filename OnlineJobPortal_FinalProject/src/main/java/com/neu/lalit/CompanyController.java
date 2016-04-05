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

import com.neu.lalit.dto.CompanyRegistration;
import com.neu.lalit.pojo.Company;
import com.neu.lalit.service.CompanyService;

@Controller
@RequestMapping(value = "/empregister.htm")
public class CompanyController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	CompanyService companyservice;

	@RequestMapping(method = RequestMethod.POST)
	public String singin(@ModelAttribute("companyRegistration") @Valid CompanyRegistration companyRegistration,
			BindingResult result, ModelMap model) {

		// @Valid is used for Bean validation not using any other spring or
		// hibernate validator. Rather using JSR-303 bean validation capability

		logger.debug("CompanyContoller#register() working");

		// Check if there is any Binding error
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println("Object name: " + error.getObjectName());
				System.out.println("Arguments : " + error.getArguments());
				System.out.println("Default message : " + error.getDefaultMessage());
			}
			model.put("companyRegistration", companyRegistration);
			return "empregister";
		}

		// check password and confirm password match
		if (!companyRegistration.getPassword().equals(companyRegistration.getConfirmPassword())) {
			model.addAttribute("passNotMatch", true);
			return "empregister";
		}


		// check if user exist
		Company c = companyservice.getCompanybyEmail(companyRegistration.getEmail());
		if (c == null) {
			// Save the user to database

			Company newcompany = companyRegistration.getCompany();
			companyservice.save(newcompany);		
			
			model.addAttribute("company", newcompany);
			model.addAttribute("signupSuccess",true);
			return "empregister";
			
		} else {
			model.addAttribute("duplicateEmailError", true);
			return "empregister";
		}
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("companyRegistration") CompanyRegistration companyRegistration,
			BindingResult result) throws Exception {
		return "empregister";
	}
	
	
}
