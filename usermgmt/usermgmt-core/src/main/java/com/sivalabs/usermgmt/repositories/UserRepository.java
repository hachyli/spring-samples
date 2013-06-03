package com.sivalabs.usermgmt.repositories;

import java.util.List;

import com.sivalabs.usermgmt.entities.User;

public interface UserRepository 
{
	
	public int createUser(User user);
	
	public User findUserById(Integer userId);

	public List<User> findAllUsers();
	
	public int updateUser(User user);
	
	public int deleteUser(Integer userId);
	
	public int deleteAllUsers();

	public User login(User user);

	public List<User> searchUsers(String searchName);

	public boolean isUserNameExists(String userName);

	public boolean isEmailIdExists(String emailId);
	
	public int getUserIdByEmailId(String emailId);

}