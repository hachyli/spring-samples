/**
 * 
 */
package com.sivalabs.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.blog.entities.User;
import com.sivalabs.blog.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

}
