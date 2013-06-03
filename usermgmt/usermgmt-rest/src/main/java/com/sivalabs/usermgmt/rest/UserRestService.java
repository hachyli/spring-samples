package com.sivalabs.usermgmt.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.usermgmt.domain.UsersResponse;
import com.sivalabs.usermgmt.entities.User;
import com.sivalabs.usermgmt.services.UserService;

/**
 * @author Siva
 *
 */
@Controller
@RequestMapping("/users/")
public class UserRestService
{
	@Autowired private UserService userService;
	
	@RequestMapping(value="")
	@ResponseBody 
	public UsersResponse getUsers(@RequestHeader("Accept") String acceptHeader)
	{
		System.err.println("header-->"+acceptHeader);
		return new UsersResponse(userService.findAllUsers());
	}
		
	@RequestMapping(value="{userId}")
	@ResponseBody 
	public User getUser(@PathVariable("userId") Integer userId)
	{
		return userService.findUserById(userId);
	}
}
