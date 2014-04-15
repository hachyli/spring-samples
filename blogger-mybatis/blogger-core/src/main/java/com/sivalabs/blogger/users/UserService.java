/**
 * 
 */
package com.sivalabs.blogger.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.blogger.domain.User;

/**
 * @author Siva
 * 
 */
@Service
@Transactional
public class UserService
{
	@Autowired
	private UserMapper userMapper;

	public User login(String userName, String password)
	{
		return userMapper.login(userName, password);
	}

}
