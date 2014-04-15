package com.sivalabs.forum.web.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sivalabs.forum.domain.User;
import com.sivalabs.forum.services.UserService;
import com.sivalabs.forum.web.util.UserContextHolder;

@Controller
public class UserController
{
	private Logger logger = LogManager.getLogger(getClass());
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView showLoginForm()
	{
		ModelAndView mav = new ModelAndView("login");
		User loginBean = new User();
		mav.getModel().put("login", loginBean);
		//mav.getModelMap().put("login", loginBean);
		return mav;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute("login") User loginBean,
							HttpServletRequest request, 
							HttpServletResponse response) 
				
	{
		ModelAndView mav = new ModelAndView();
		String view = "login";
		String userName = loginBean.getUserName();
		String password = loginBean.getPassword();
		
		User user = userService.login(userName, password);
		if(user != null)
		{
			logger.info(user.getFirstName()+" logged into the system.");
			//request.getSession().setAttribute("LOGGEDIN_USER", user);
			UserContextHolder.setLoggedinUser(request.getSession(), user);
			view = "redirect:forums";
		}else{
			logger.error("Login failed.");
			request.setAttribute("ERROR", "Invalid Username and Password");
		}
		mav.setViewName(view);
		return mav;
	}
	
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		request.getSession().invalidate();
		response.sendRedirect("redirect:forums");
	}
	
	@RequestMapping(value="/createUser", method=RequestMethod.GET)
	public ModelAndView showNewUserForm()
	{
		ModelAndView mav = new ModelAndView("newUser");
		User user = new User();
		mav.getModel().put("newUser", user);
		return mav;
	}
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("newUser") User user)
	{
		ModelAndView mav = new ModelAndView("redirect:login");
		this.userService.create(user);
		return mav;
	}
	/*
	@RequestMapping(value="/updateUser", method=RequestMethod.GET)
	public ModelAndView editUserForm(@RequestParam("userId") int id)
	{
		ModelAndView mav = new ModelAndView("editUser");
		User user = this.userService.getUserById(id);
		mav.getModel().put("editUser", user);
		return mav;
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("editUser") User user)
	{
		ModelAndView mav = new ModelAndView("redirect:showUsers.do");
		this.userService.update(user);
		return mav;
	}
	*/
	
}
