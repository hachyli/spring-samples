/**
 * 
 */
package com.sivalabs.usermgmt.ws.soap;

import java.util.List;

import javax.jws.WebService;

import com.sivalabs.usermgmt.entities.User;

/**
 * @author Siva
 *
 */
@WebService
public interface IUserMgmtService 
{
	public List<User> searchUsers(String searchName);

	User createUser(User user);
	
	public String sayHello(String name);
}
