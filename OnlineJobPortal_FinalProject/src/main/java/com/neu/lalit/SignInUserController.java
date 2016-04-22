package com.neu.lalit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.servlet.ModelAndView;

import com.neu.lalit.pojo.User;
import com.neu.lalit.service.UserService;

@Controller
@RequestMapping(value = "/signin.htm")
public class SignInUserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userservice;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView executeSignIn(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("user") User user, BindingResult result )
	 {
		HttpSession httpSession = request.getSession(true);
		ModelAndView model = null;
		// @Valid is used for Bean validation not using any other spring or
		// hibernate validator. Rather using JSR-303 bean validation capability

		logger.debug("SignInUserController#register() working");

		// Check if there is any Binding error
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println("Object name: " + error.getObjectName());
				System.out.println("Arguments : " + error.getArguments());
				System.out.println("Default message : " + error.getDefaultMessage());
			}
			model.addObject("user",user);
			return model;
//			model.put("user", user);
//			return "signin";
		}

		User newuser = userservice.getByEmail(user.getEmail());
		if (!(newuser == null)) {
			if (newuser.getEmail().equals(user.getEmail()) && newuser.getPassword().equals(user.getPassword())) {
				httpSession.setAttribute("user", newuser);
				model = new ModelAndView("userlanding");
				model.addObject("userLogged",newuser);
				return model;
//				model.addAttribute("userLogged", newuser);
//				return "searchjob";
			}

		} else {
			 model = new ModelAndView("signin");			
			 model.addObject("user", user);		
			 request.setAttribute("message", "UserName or Password you entered does not match! Try again");

			
//			model.put("user", user);
//			return "signin";

		}
		logger.debug("User was not authenticated.");
		return model;
//		return "signin";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) throws Exception {
		return "signin";
	}

}
