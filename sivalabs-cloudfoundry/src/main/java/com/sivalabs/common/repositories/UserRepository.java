/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.common.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.common.model.User;

/**
 * @author K. Siva Prasad Reddy
 * Date : 04-Nov-2011
 */
@Repository
@Transactional
public class UserRepository
{
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("rawtypes")
	public Integer create(User user)
	{
		Query query = this.entityManager.createQuery("select u.userId from User u where username=?", Integer.class);
		query.setParameter(1, user.getUsername());
		query.getFirstResult();
		List list = query.getResultList();
		if(list!= null && !list.isEmpty())
		{
			return -1;
		}
		this.entityManager.persist(user);
		return user.getUserId();
	}
	
	@SuppressWarnings("rawtypes")
	public Integer login(String username, String password)
	{
		Integer userId = -1;
		Query query = this.entityManager.createQuery("select u.userId from User u where username=? and password=?", Integer.class);
		query.setParameter(1, username);
		query.setParameter(2, password);
		query.getFirstResult();
		List list = query.getResultList();
		if(list!= null && !list.isEmpty())
		{
			userId = (Integer)list.get(0);
		}
		return userId;
	}
	
	public User	getUserById(Integer userId)
	{
		return this.entityManager.find(User.class, userId);
	}
}
