/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.common.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.sivalabs.common.model.User;
import com.sivalabs.common.repositories.UserRepository;
import com.sivalabs.common.web.validators.RegistrationFormValidator;

/**
 * @author K. Siva Prasad Reddy
 * Date : 04-Nov-2011
 */

@Controller
public class RegistrationController
{
	
	@Autowired private RegistrationFormValidator registrationFormValidator;
	@Autowired private UserRepository userRepository;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView registrationForm(Model model)
	{
		ModelAndView mav = new ModelAndView("registration");
		mav.addObject("registration", new User());
		return mav;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView login(HttpSession session, @ModelAttribute("registration") User user, BindingResult result, SessionStatus status)
	{
		ModelAndView mav = new ModelAndView("registration");
		this.registrationFormValidator.validate(user, result);
		if(result.hasErrors()){
    		return mav;
    	}
		Integer userId = this.userRepository.create(user);
		
		if(userId != -1)
		{
			//System.out.println("UserId="+userId);
			status.setComplete();
			mav.setViewName("redirect:login.htm");
		}else{
			mav.addObject("errorMsg", "UserName already exists.");
		}
		
		return mav;
	}
}
