/**
 * 
 */
package com.sivalabs.springcore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siva
 *
 */
public class UserRepository 
{
	
	public User findUserById(Integer userId) 
	{
		User user = new User();
		user.setUserId(userId);
		user.setUserName("User"+userId);
		return user;
	}

	public List<User> findAllUsers() {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 5; i++)
		{
			users.add(new User(i, "User"+i));			
		}
		return users;
	}
}
