package com.neu.lalit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.lalit.pojo.Application;
import com.neu.lalit.service.ApplicationService;

@Controller
@RequestMapping(value="/withdrawapplication.htm")
public class UserApplicationWithdraw {

	
	
	@Autowired
	ApplicationService applicationservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String withdrawApplication(HttpServletRequest request, HttpServletResponse response){
		String result = "";
		
		String action = request.getParameter("action");
		
		if(action.equals("withdraw")){
			Long appId = Long.parseLong(request.getParameter("appId"));
			
			
			if (appId == null || appId == 0 ) {
				result = "Found issue";
				return result;
			}
			
			Application application = applicationservice.getById(appId);
			if(application!= null){
				
				applicationservice.deleteApplication(appId);
				result = "SUCCESS";
				
			} else {
				result = "Found issue";
				return result;
			}
			
			
		}
		
		return result;
	}
	
}
