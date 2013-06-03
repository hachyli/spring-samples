/**
 * 
 */
package com.sivalabs.usermgmt.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sivalabs.usermgmt.entities.User;
import com.sivalabs.usermgmt.services.UserService;
import com.sivalabs.usermgmt.ws.rest.domain.UsersResponse;

/**
 * @author Siva
 *
 */
@Path("/")
@Component("UserMgmtRestService")
public class UserMgmtRestService 
{

	@Autowired 
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@GET
	@Path("/users")
	@Produces ("application/xml")
	public UsersResponse getUsers() 
	{
		UsersResponse response = new UsersResponse();
		response.setUsers(userService.findAllUsers());
		return response;
	}
	
	@GET
	@Path("/searchUsers/{searchName}")
	@Produces ("application/xml")
	public UsersResponse searchUsers(@PathParam ("searchName") String searchName) 
	{
		UsersResponse response = new UsersResponse();
		response.setUsers(userService.searchUsers(searchName));
		return response;
	}
	
	@POST
	@Path("/createUser}")
	@Produces ("application/xml")
	public User createUser(User user) 
	{
		return userService.createUser(user);
	}
}
