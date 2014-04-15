/**
 * 
 */
package com.sivalabs.linkshare.web.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sivalabs.linkshare.entities.Link;
import com.sivalabs.linkshare.entities.User;
import com.sivalabs.linkshare.entities.UserLogon;
import com.sivalabs.linkshare.web.validators.Validators;

/**
 * @author skatam
 *
 */
@Controller
public class UserProfileController extends BaseController
{
	
	@RequestMapping("secure/showUsers")
	public String showUsers(Model model) 
	{
		List<User> users = this.getLinkShareService().findAllUsers();
		model.addAttribute("USERS_KEY", users);
		return "showUsers";
	}
	
	@RequestMapping(value="registration", method=RequestMethod.GET)
	public String showRegistrationForm(Model model) 
	{
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@RequestMapping(value="registration", method=RequestMethod.POST)
	public String registerUser(@Validated(Validators.RegistrationValidation.class) @ModelAttribute User user,
								BindingResult result, 
								Model model) 
	{
		if(result.hasErrors())
		{
			return "registration";
		}
		Integer userId = this.getLinkShareService().saveUser(user);
		logger.debug("New UserId : "+userId);
		return "redirect:login.htm";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String showLoginForm(Model model) 
	{
		model.addAttribute("userLogon", new UserLogon());
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@Validated(Validators.LoginValidation.class) @ModelAttribute UserLogon user, 
								BindingResult result, 
								Model model, 
								HttpSession session) 
	{
		if(result.hasErrors())
		{
			return "login";
		}
		
		User loginUser = this.getLinkShareService().login(user.getUsername(), user.getPassword());
		if(loginUser !=null)
		{
			this.setLoggedInUser(session, loginUser);
			return "redirect:home.htm";
		}
		else
		{
			result.reject("login.failed", "Login Failed. Please try again");
			return "login";
		}
	}
	
	@RequestMapping(value="showUserProfile")
	public String showUserProfile(Model model, HttpSession session) 
	{
		User loggedInUser = this.getLoggedInUser(session);
		model.addAttribute("userProfile", loggedInUser);
		List<Link> userLinks = this.getLinkShareService().findUserLinks(loggedInUser.getUserId());
		model.addAttribute("USER_LINKS", userLinks);
		
		return "userProfile";
	}
}
