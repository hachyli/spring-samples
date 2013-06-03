/**
 * 
 */
package com.sivalabs.forum.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.forum.entities.User;
import com.sivalabs.forum.repositories.UserRepository;

/**
 * @author Siva
 * 
 */
@Service
@Transactional
public class UserService
{
	
	@PersistenceContext 
	private EntityManager em;
	
	@Autowired 
	private UserRepository userRepository;
	
	
	public List<User> findAllUsers()
	{
		return userRepository.findAll();
	}
	public User login(String username, String password)
	{
		return userRepository.login(username, password);
	}
	
	public User findUserById(Long userId)
	{
		return userRepository.findOne(userId);
	}
	public User findUserByUsername(String username)
	{
		return userRepository.findUserByUsername(username);
	}
	public User findUserByEmail(String email)
	{
		return userRepository.findUserByEmail(email);
	}
	public boolean isUsernameExists(String username)
	{
		return userRepository.isUsernameExists(username)>0;
	}
	public boolean isEmailExists(String email)
	{
		return userRepository.isEmailExists(email)>0;
	}
	public User create(User user)
	{
		if(isUsernameExists(user.getUsername())){
			throw new RuntimeException("Username ["+user.getUsername()+"] already in use.");
		}
		
		if(isEmailExists(user.getEmail())){
			throw new RuntimeException("Email ["+user.getEmail()+"] already in use.");
		}
		user.setId(null);
		em.persist(user);
		return user;
	}
	
	public User update(User user)
	{
		if(userRepository.findOne(user.getId()) == null){
			throw new RuntimeException("No User exists with id : "+user.getId());
		}
		return em.merge(user);
	}
	
	public void delete(Long userId)
	{
		User user = userRepository.findOne(userId);
		if(user == null){
			throw new RuntimeException("No User exists with id : "+userId);
		}
		em.remove(user);
	}
}
