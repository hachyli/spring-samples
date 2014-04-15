package com.sivalabs.blogosphere.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.blogosphere.domain.User;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class UserServiceTest
{
	@Autowired
	private UserService ums;
		
	public static void main(String[] args)
	{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/applicationContext.xml");
		UserService ums = ctx.getBean(UserService.class);
		User user = ums.login("sivaprasadreddy.k@gmail.com", "siva");
		System.out.println(user);
		
		
	}
	
	@Test
	public void testDummy()
	{
		assertTrue(true);
	}
	
	@Test
	public void testUserLogin()
	{
		User user = ums.login("sivaprasadreddy.k@gmail.com", "siva");
		assertNotNull(user);
	}
	
	@Test
	public void testCreateUser()
	{
		/*User adminUser = new User();
		adminUser.setEmailId("admin@gmail.com");
		adminUser.setPassword("admin");
		adminUser.setFirstName("Administrator");
		
		ums.createUser(adminUser);
		System.out.println(adminUser.getUserId());
		
		User sivaUser = new User();
		sivaUser.setEmailId("siva@gmail.com");
		sivaUser.setPassword("siva");
		sivaUser.setFirstName("Siva");
		sivaUser.setLastName("K");
		ums.createUser(sivaUser);
		System.out.println(sivaUser.getUserId());
		
		User testUser = new User();
		testUser.setEmailId("test@gmail.com");
		testUser.setPassword("test");
		testUser.setFirstName("Tester");
		
		ums.createUser(testUser);
		System.out.println(testUser.getUserId());
		*/
		
		User guestUser = new User();
		guestUser.setUserName("guest");
		guestUser.setPassword("guest");
		guestUser.setEmailId("guest@gmail.com");
		guestUser.setFirstName("Guest");
		
		User createdUser = ums.createUser(guestUser);
		System.out.println(createdUser.getUserId());
	}
	
	@Test
	public void testUpdateUser()
	{
		User user = new User();
		user.setUserId(3);
		user.setEmailId("admin@gmail.com");
		user.setPassword("admin123");
		user.setFirstName("Admin123");
		user.setLastName("Mr");
		User updatedUser = ums.updateUser(user);
		assertEquals(user.getEmailId(), updatedUser.getEmailId());
		assertEquals(user.getPassword(), updatedUser.getPassword());
		assertEquals(user.getFirstName(), updatedUser.getFirstName());
		assertEquals(user.getLastName(), updatedUser.getLastName());
		
	}
	
	@Test
	public void testDeleteUser()
	{
		User user = new User();
		user.setUserId(3);
		ums.deleteUser(user);
	}
	
}
