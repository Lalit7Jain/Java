package com.neu.lalit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.lalit.dto.UserApplication;
import com.neu.lalit.pojo.User;
import com.neu.lalit.service.UserService;

@Controller
@RequestMapping(value = "/user/{id}/myappliedjob.htm")
public class UserAppliedJobs {

	@Autowired
	UserService userservice;

	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView userUpdate(@PathVariable ("id") Long userid, HttpServletRequest request){
		ModelAndView mav = null;
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		if(u == null){
			mav = new ModelAndView("userapplicationlist");
			return mav;
		}
		
		
		
		if(userid!= null && (userid.longValue() == u.getId().longValue())){
			
		List<UserApplication> applicationlist = userservice.myApplication(userid);
		mav = new ModelAndView("userapplicationlist","myapplicationlist",applicationlist);
		mav.addObject("noofapplication", applicationlist.size());
		
		} else {
		
			mav = new ModelAndView("userapplicationlist");
			
		}
		
		return mav;
	}
	
}
