/**
 * 
 */
package com.sivalabs.usermgmt.services;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.usermgmt.entities.User;
import com.sivalabs.usermgmt.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService
{
	@Autowired private UserRepository userRepository;
	
	public User createUser(User user) {
		boolean userNameExists = userRepository.isUserNameExists(user.getUserName());
		if(userNameExists){
			throw new RuntimeException("UserName ["+user.getUserName()+"] already in use.");
		}
		if(!StringUtils.isBlank(user.getEmailId()))
		{
			boolean emailIdExists = userRepository.isEmailIdExists(user.getEmailId());
			if(emailIdExists){
				throw new RuntimeException("EmailId ["+user.getEmailId()+"] already in use.");
			}
		}
		userRepository.createUser(user);
		return user;
	}

	public User findUserById(Integer userId) {
		return userRepository.findUserById(userId);
	}

	public User updateUser(User user) {
		if(!StringUtils.isBlank(user.getEmailId()))
		{
			Integer userId = userRepository.getUserIdByEmailId(user.getEmailId());
			if(userId != null && userId != user.getUserId()){
				throw new RuntimeException("EmailId ["+user.getEmailId()+"] already in use.");
			}
		}
		userRepository.updateUser(user);
		return user;
	}

	public boolean deleteUser(Integer userId) {
		int count = userRepository.deleteUser(userId);
		return count>0;
	}

	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}
	public boolean deleteAllUsers() {
		userRepository.deleteAllUsers();
		return true;
	}

	public User login(String userName, String password) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		return userRepository.login(user);
	}

	public List<User> searchUsers(String searchName) {
		return userRepository.searchUsers(searchName);
	}
}
