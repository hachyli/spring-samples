package com.sivalabs.usermgmt.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.usermgmt.entities.User;
import com.sivalabs.usermgmt.utils.DBInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class UserServiceTest
{
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) 
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		DBInitializer dbInitializer = ctx.getBean(DBInitializer.class);
		System.out.println(dbInitializer);
	}
	
	@Test
	public void testFindAllUsers() {
		List<User> users = userService.findAllUsers();
		Assert.assertNotNull(users);
		for (User user : users) {
			System.err.println(user);
		}
	}
	
	@Test
	public void testCreateUser() 
	{
		User user = new User("test","test","Test");
		User createdUser = userService.createUser(user);
		System.err.println(createdUser.getUserId());
	}

	@Test
	public void testFindUserById() 
	{
		User user = userService.findUserById(1);
		assertNotNull(user);
		System.out.println(user);
	}

	@Test
	public void testUpdateUser() 
	{
		User user = userService.findUserById(3);
		assertNotNull(user);
		user.setLastName("Mr");
		user.setEmailId("guest@gmail.com");
		user.setDisabled(true);
		userService.updateUser(user);
		User updatedUser = userService.findUserById(user.getUserId());
		assertEquals(user.getLastName(), updatedUser.getLastName());
		assertEquals(user.getEmailId(), updatedUser.getEmailId());
		assertEquals(user.isDisabled(), updatedUser.isDisabled());
		
	}

	@Test(expected=RuntimeException.class)
	public void testUpdateUserWithExistingEmail() 
	{
		User user = userService.findUserById(3);
		assertNotNull(user);
		user.setLastName("Mr");
		user.setEmailId("admin@gmail.com");
		user.setDisabled(true);
		userService.updateUser(user);
		User updatedUser = userService.findUserById(user.getUserId());
		assertEquals(user.getLastName(), updatedUser.getLastName());
		assertEquals(user.getEmailId(), updatedUser.getEmailId());
		assertEquals(user.isDisabled(), updatedUser.isDisabled());
		
	}
	@Test
	public void testDeleteUser() 
	{
		User user = userService.findUserById(3);
		assertNotNull(user);
		userService.deleteUser(user.getUserId());
		user = userService.findUserById(user.getUserId());
		assertNull(user);
	}

	@Test
	public void testDeleteAllUsers()
	{
		boolean usersDeleted = userService.deleteAllUsers();
		assertTrue(usersDeleted);
	}

	@Test
	public void testLogin()
	{
		String userName="admin";
		String password="admin";
		User user = userService.login(userName, password);
		assertNotNull(user);
	}

	@Test
	public void testSearchUsers()
	{
		String searchName = "";
		List<User> searchUsers = userService.searchUsers(searchName);
		assertNotNull(searchUsers);
		
	}
}
