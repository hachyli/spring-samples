/**
 * 
 */
package com.sivalabs.blogger.users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.blogger.config.AppConfig;
import com.sivalabs.blogger.domain.User;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserServiceTests 
{
	@Autowired
	UserService userService;
	
	@Test
	public void testLogin() {
		User user = userService.login("siva", "siva");
		System.err.println(user);
	}
}
