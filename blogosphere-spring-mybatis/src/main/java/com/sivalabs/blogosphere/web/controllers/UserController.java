/**
 * 
 */
package com.sivalabs.blogosphere.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sivalabs.blogosphere.domain.Blog;
import com.sivalabs.blogosphere.domain.User;
import com.sivalabs.blogosphere.service.BlogService;
import com.sivalabs.blogosphere.service.UserService;
import com.sivalabs.blogosphere.web.views.LoginForm;
import com.sivalabs.blogosphere.web.views.UserAccountView;

/**
 * @author Siva
 *
 */
@Controller
public class UserController 
{

	@Autowired private BlogService blogService;
	@Autowired private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(Model model)
	{
		LoginForm form = new LoginForm();
		model.addAttribute("login", form);
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("login") LoginForm loginForm, HttpServletRequest request)
	{
		String view = "login";
		User user = userService.login(loginForm.getUserName(), loginForm.getPassword());
		if(user == null)
		{
			loginForm.setLoginStatus("Login failed, Please try again.");
		}
		else
		{
			request.getSession().setAttribute("LOGIN_USER", user);
			view = "redirect:home";
		}
		return view;
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:login";
	}
	
	@RequestMapping(value="welcome", method=RequestMethod.GET)
	public String welcome(Model model) 
	{
		return "welcome";
	}
	
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) 
	{
		User loginUser = this.getLoginUser(request);
		Integer userId = loginUser.getUserId();
		User user = this.userService.getUserById(userId);
		List<Blog> blogs = blogService.getUserBlogs(userId);
		user.setBlogs(blogs);
		UserAccountView uav = new UserAccountView();
		uav.setUser(user);
		uav.setAllBlogs(blogService.getAllBlogs());
		model.addAttribute("UserAccount", uav);
		return "home";
	}
	
    User getLoginUser(HttpServletRequest request)
	{
		return (User) request.getSession().getAttribute("LOGIN_USER");
	}
}
