/**
 * 
 */
package com.sivalabs.forum.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sivalabs.forum.entities.User;
import com.sivalabs.forum.services.UserService;

/**
 * @author Siva
 *
 */
@Controller
public class UserController 
{

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users/{username}")
	public String showUserProfile(@PathVariable("username") String username, Model model)
	{
		User user = userService.findUserByUsername(username);
		model.addAttribute("user", user);
		return "userAccount";
	}
}
