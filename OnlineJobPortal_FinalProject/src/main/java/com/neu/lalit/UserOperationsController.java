package com.neu.lalit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.lalit.pojo.User;
import com.neu.lalit.service.UserService;

@Controller
@RequestMapping(value = "/user/{id}/update.htm")
public class UserOperationsController {
	
	@Autowired
	UserService userservice;

	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView userUpdate(@PathVariable ("id") Long id){
		ModelAndView mav = null;
		User user = userservice.getById(id);
		mav = new ModelAndView("userupdateform","userupdate",user);
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView userSave(@PathVariable ("id") Long id, User user){
		ModelAndView mav = null;
		userservice.update(user);
		String message = "Updated profile sucessfully! Please sign in again since we have changed your profile";
		mav = new ModelAndView("userupdateform","message",message);
		return mav;
		
		
	}
	
	
}
