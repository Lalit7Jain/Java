package com.neu.lalit;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import com.neu.lalit.dto.UserRegistration;
import com.neu.lalit.pojo.Resume;
import com.neu.lalit.pojo.User;
import com.neu.lalit.service.ResumeService;
import com.neu.lalit.service.UserService;

@Controller
@RequestMapping(value = "/register.htm")
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userservice;

	@Autowired
	ResumeService resumeservice;

	String resumePath = "C:/Users/lalit/Desktop/portalresume/";

	@RequestMapping(method = RequestMethod.POST)
	public String singin(@ModelAttribute("userRegistration") @Valid UserRegistration userRegistration,
			BindingResult result, ModelMap model) {

		// @Valid is used for Bean validation not using any other spring or
		// hibernate validator. Rather using JSR-303 bean validation capability

		logger.debug("UserController#register() working");

		// Check if there is any Binding error
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println("Object name: " + error.getObjectName());
				System.out.println("Arguments : " + error.getArguments());
				System.out.println("Default message : " + error.getDefaultMessage());
			}
			model.put("userRegistration", userRegistration);
			return "register";
		}

		// check password and confirm password match
		if (!userRegistration.getPassword().equals(userRegistration.getConfirmPassword())) {
			model.addAttribute("passNotMatch", true);
			return "register";
		}


		// check if user exist
		User u = userservice.getByEmail(userRegistration.getEmail());
		if (u == null) {
			// Save the user to database

			User newuser = userRegistration.getUser();
			Long userId = userservice.save(newuser);

			// save the user's resume
			CommonsMultipartFile resumefile = userRegistration.getResume();
			Resume resume = new Resume();
			resume.setTitle(resumefile.getOriginalFilename());
			resume.setPath(userId + "/" + resumefile.getOriginalFilename());
			resume.setDescription(newuser.getFirstname() + " " + newuser.getLastname());
			resume.setUser(newuser);
			resumeservice.save(resume);

			// save resume to disc
			try {
				File file = new File(resumePath + resume.getPath());
				file.mkdirs(); // Make parent directories in the path provided.
								// Whereas mkdir only makes one folder
				resumefile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//Sending Email to the User
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("lalit.7.jain@gmail.com", "Outlook@13"));
			email.setSSL(true);
			try {
				email.setFrom("onlineportal@gmail.com");
				email.setSubject("Welcome aboard to Online Job Portal");
				email.setMsg(" This is to confirm that you have been sucessfully registered with us! ");
				email.addTo(newuser.getEmail());
				email.send();
			} catch (EmailException e) {
				
				e.printStackTrace();
			}
			
			
			//Redirecting to register page for successful signup
			model.addAttribute("signupSuccess",true);
			return "register";
			
		} else {
			model.addAttribute("duplicateEmailError", true);
			return "register";
		}
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("userRegistration") UserRegistration userRegistration,
			BindingResult result) throws Exception {
		return "register";
	}
}
