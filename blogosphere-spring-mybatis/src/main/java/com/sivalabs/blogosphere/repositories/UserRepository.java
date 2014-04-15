package com.sivalabs.blogosphere.repositories;

import com.sivalabs.blogosphere.domain.User;

/**
 * @author Siva
 *
 */
public interface UserRepository
{
	void createUser(User user);
	void updateUser(User user);
	void deleteUser(Integer userId);
	User getUserById(Integer userId);
	User login(String emailId, String pwd);
	boolean emailIdExists(String emailId);
	boolean userNameExists(String userName);
}
