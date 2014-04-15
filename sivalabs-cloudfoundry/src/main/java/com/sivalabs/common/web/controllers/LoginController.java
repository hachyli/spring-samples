/**
 * 
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

import com.sivalabs.common.model.LoginBean;
import com.sivalabs.common.model.User;
import com.sivalabs.common.repositories.UserRepository;
import com.sivalabs.common.web.util.UserContextUtil;
import com.sivalabs.common.web.validators.LoginFormValidator;

/**
 * @author K. Siva Prasad Reddy
 *
 */
@Controller
public class LoginController
{
	@Autowired private LoginFormValidator loginFormValidator;
	@Autowired private UserRepository userRepository;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginForm(Model model)
	{
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new LoginBean());
		return mav;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(HttpSession session, @ModelAttribute("login") LoginBean loginBean, BindingResult result, SessionStatus status)
	{
		ModelAndView mav = new ModelAndView("login");
		this.loginFormValidator.validate(loginBean, result);
		if(result.hasErrors()){
    		return mav;
    	}
		Integer userId = this.userRepository.login(loginBean.getUsername(), loginBean.getPassword());
		//if("admin".equals(loginBean.getUsername()) && "admin".equals(loginBean.getPassword()))
		if(userId != -1)
		{
			mav.setViewName("redirect:home.htm");
			User user =  this.userRepository.getUserById(userId);
			//User user =  new User(1, "admin", "admin", "Siva Prasad Reddy", "K");
			UserContextUtil.initUserContext(session, user);
			
			status.setComplete();
		}else{
			mav.addObject("errorMsg", "Invalid UserName and Password.");
		}
		return mav;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:login.htm";
	}

}
