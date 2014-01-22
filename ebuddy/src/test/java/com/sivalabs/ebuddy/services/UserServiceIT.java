/**
 * 
 */
package com.sivalabs.ebuddy.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.ebuddy.entities.User;

/**
 * @author Siva
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserServiceIT
{
	@Autowired
	private UserService userService;

	@Test
	public void findAllUsers()
	{
		List<User> users = userService.findAllUsers();
		assertNotNull(users);
		System.err.println(users);
	}
}
