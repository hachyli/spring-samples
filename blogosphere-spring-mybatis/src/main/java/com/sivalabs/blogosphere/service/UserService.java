package com.sivalabs.blogosphere.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.blogosphere.BlogosphereException;
import com.sivalabs.blogosphere.domain.User;
import com.sivalabs.blogosphere.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService
{
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired private SqlSession sqlSession;
	@Autowired private UserRepository userRepository;
	
	public User createUser(User user)
	{
		if(userRepository.userNameExists(user.getUserName()))
		{
			logger.warn("UserName ["+user.getUserName()+"] already in use.");
			throw new BlogosphereException("UserName ["+user.getUserName()+"] already in use.");
		}
		if(userRepository.emailIdExists(user.getEmailId()))
		{
			logger.warn("Email Id ["+user.getEmailId()+"] already in use.");
			throw new BlogosphereException("Email Id ["+user.getEmailId()+"] already in use.");
		}
		userRepository.createUser(user);
		return user;
	}

	public User updateUser(User user)
	{
		userRepository.updateUser(user);
		return user;
	}

	public void deleteUser(User user)
	{
		userRepository.deleteUser(user.getUserId());
	}
	
	public User getUserById(Integer userId)
	{
		return userRepository.getUserById(userId);
	}

	public User login(String loginId, String pwd)
	{
		//return sqlSession.getMapper(UserRepository.class).login(emailId, pwd);
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginId", loginId);
		map.put("password", pwd);
		return (User)sqlSession.selectOne("com.sivalabs.blogosphere.repositories.UserRepository.login", map );
	}

}
