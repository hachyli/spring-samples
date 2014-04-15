/**
 * 
 */
package com.sivalabs.forum.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.forum.domain.User;

/**
 * @author siva
 *
 */
@Service
@Transactional
public class UserService extends AbstractService
{
	public User login(String userName, String password)
	{
		return this.getDaoFactory().getUserDAO().login(userName, password);
	}
	
	public Integer createUser(User user)
	{
		return this.getDaoFactory().getUserDAO().create(user);
	}
	
	public Integer create(User obj)
	{
		return this.getDaoFactory().getUserDAO().create(obj);
	}

	public User getUserById(Integer id)
	{
		return this.getDaoFactory().getUserDAO().getById(id);
	}

	public Collection<User> getAllUsers()
	{
		return this.getDaoFactory().getUserDAO().getAll();
	}

	public void update(User obj)
	{
		this.getDaoFactory().getUserDAO().update(obj);
	}

	public void delete(User obj)
	{
		this.getDaoFactory().getUserDAO().delete(obj);
	}
}
