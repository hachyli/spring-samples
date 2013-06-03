package com.sivalabs.forum.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.forum.config.AppConfig;
import com.sivalabs.forum.entities.User;
import com.sivalabs.forum.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserServiceTest 
{

	@Autowired
	private UserService userService;
	
	@Test
	public void findAllUsers() 
	{
		List<User> allUsers = userService.findAllUsers();
		assertNotNull(allUsers);
		
	}

	@Test
	public void login()
	{
		String username="admin", password="admin";
		User user = userService.login(username, password);
		assertNotNull(user);
	}

	@Test
	public void findUserById()
	{
		Long userId = 1L;
		User user =  userService.findUserById(userId);
		assertNotNull(user);
	}

	@Test
	public void findUserByUsername()
	{
		String username =  "admin";
		User user =  userService.findUserByUsername(username);
		assertNotNull(user);
	}

	@Test
	public void findUserByEmail()
	{
		String email= "admin@gmail.com";
		User user =  userService.findUserByEmail(email);
		assertNotNull(user);
	}

	@Test
	public void isUsernameExists()
	{
		String username = "admin";
		boolean exists = userService.isUsernameExists(username);
		assertTrue(exists);
	}

	@Test
	public  void isEmailExists()
	{
		String email = "admin@gmail.com";
		boolean exists = userService.isEmailExists(email);
		assertTrue(exists);
	}

	@Test
	public void create()
	{
		User user = new User();
		String prefix = "user_"+System.currentTimeMillis();
		user.setUsername(prefix);
		user.setEmail(prefix+"@gmail.com");
		user.setPassword(prefix);
		user.setName(prefix);
		
		User createdUser =  userService.create(user);
		assertNotNull(createdUser);
	}

	@Test
	public void update()
	{
		User user = userService.findUserByUsername("test");
		String email = "test_"+System.currentTimeMillis()+"@gmail.com";
		user.setEmail(email);
		User updatedUser =  userService.update(user);
		assertNotNull(updatedUser);
		assertEquals(email, updatedUser.getEmail());
	}

	@Test
	public void delete()
	{
		Long userId = 5L;
		userService.delete(userId);
	}

	

	

}
