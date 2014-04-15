/**
 * 
 */
package com.sivalabs.jbb.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.jbb.entities.User;
import com.sivalabs.jbb.services.UserService;

/**
 * @author Siva
 *
 */
@Controller
@RequestMapping(value="/users", produces="application/json")
public class UserRestService 
{

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/**", produces="text/html")
	@ResponseBody
	public String welcome() 
	{
		return "<h1>Welcome to JBB</h1>";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUsers() 
	{
		 List<User> users = userService.findAllUsers();
		 return users;
	}
	
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable("userId") Integer userId) 
	{
		 User user = userService.getUserById(userId);
		 return user;
	}
	
	@RequestMapping(value="/username/{username}", method=RequestMethod.GET)
	@ResponseBody
	public User getUserByUsername(@PathVariable("username") String username) 
	{
		User user = userService.getUserByUserName(username);		
		return user;
	}
}
