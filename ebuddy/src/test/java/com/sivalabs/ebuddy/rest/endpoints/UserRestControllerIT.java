package com.sivalabs.ebuddy.rest.endpoints;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.sivalabs.ebuddy.entities.User;

/**
 * @author Siva
 * 
 */
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserRestControllerIT
{
	// @Autowired
	// private UserService userService;
	static String baseUrl = "http://localhost:9090/ebuddy/rest/";

	@Test
	public void findAllUsers()
	{
		RestTemplate restTemplate = new RestTemplate();
		User[] usersArray = restTemplate.getForObject(baseUrl + "users/", User[].class);
		List<User> users = Arrays.asList(usersArray);
		assertNotNull(users);
		System.err.println(users);
	}

	@Test
	public void findUser()
	{
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject(baseUrl + "users/1", User.class);
		assertNotNull(user);
		System.err.println(user);
	}
}
