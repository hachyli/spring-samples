package com.sivalabs.jbb.web.mvc;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sivalabs.jbb.web.mvc.domain.User;

/**
 * @author Siva
 *
 */
@Service
public class AuthenticationService
{
	
	public User getUserByUsername(String username)
	{
		RestTemplate restTemplate = new RestTemplate();
		//TODO; make it configurable
		return restTemplate.getForObject("http://localhost:8080/jbulletinboard/services/users/username/"+username, User.class);
	}
}
