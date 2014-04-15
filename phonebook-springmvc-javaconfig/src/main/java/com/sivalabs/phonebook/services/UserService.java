/**
 * 
 */
package com.sivalabs.phonebook.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.phonebook.entities.User;

/**
 * @author siva
 *
 */
@Service
@Transactional
public class UserService 
{
	@PersistenceContext()
	private EntityManager em;
	
	public User getUser(Integer userId) {
		return em.find(User.class, userId);
	}
	
	public Integer saveUser(User user) {
		User savedUser = em.merge(user);
		return savedUser.getUserId();
	}
	
	public void deleteUser(Integer userId) {
		User user = em.find(User.class, userId);
		if(user != null)
		em.remove(user);
	}

	public Integer login(String userName, String password) {
		TypedQuery<Integer> query = em.createQuery("select u.userId from User u where u.userName=?1 and u.password=?2", Integer.class);
		query.setParameter(1, userName);
		query.setParameter(2, password);
		try {
			Integer userId = query.getSingleResult();
			return userId;
		} catch (Exception e) {
		}
		return null;
	}

	public boolean changePwd(Integer userId, String pwd, String newPwd) {
		Query query = em.createQuery("update Contact set password=?1 where userId=?2 and password=?3");
		query.setParameter(1, newPwd);
		query.setParameter(2, userId);
		query.setParameter(3, pwd);
		int count = query.executeUpdate();
		return count > 0;
	}
}
