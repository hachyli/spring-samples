package com.sivalabs.forum.web;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Siva
 *
 */
@Controller
public class UserController
{
	
	@RequestMapping("listUsers")
	public String listUsers()
	{
		return "show_users";
	}
	@RequestMapping("showUser")
	public String showUser()
	{
		return "user_details";
	}
	
	public static AuthenticatedUser getLoggedinUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return (AuthenticatedUser) userDetails;
		}
		return null;
	}
}
