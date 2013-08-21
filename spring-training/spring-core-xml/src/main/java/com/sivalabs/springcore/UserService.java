package com.sivalabs.springcore;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private UserRepository userRepository;
	public void setUserRepository(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	public UserRepository getUserRepository()
	{
		return userRepository;
	}
	
	public UserService()
	{
	}
    public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
    
	public User findUserById(Integer userId)
    {
        logger.debug("UserId : {}", userId);
    	return userRepository.findUserById(userId);
    }

	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}
}
