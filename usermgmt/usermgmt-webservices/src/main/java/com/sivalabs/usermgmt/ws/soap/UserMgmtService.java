/**
 * 
 */
package com.sivalabs.usermgmt.ws.soap;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sivalabs.usermgmt.entities.User;
import com.sivalabs.usermgmt.services.UserService;

/**
 * @author Siva
 *
 */
@WebService(endpointInterface="com.sivalabs.usermgmt.ws.soap.IUserMgmtService")
@Component("UserMgmtService")
public class UserMgmtService implements IUserMgmtService 
{

	@Autowired private UserService userService;
	
	@Override
	public List<User> searchUsers(String searchName) 
	{
		return userService.searchUsers(searchName);
	}

	@Override
	public String sayHello(String name) {
		return "Hello "+name;
	}
	
	@Override
	public User createUser(User user) 
	{
		return userService.createUser(user);
	}

}
