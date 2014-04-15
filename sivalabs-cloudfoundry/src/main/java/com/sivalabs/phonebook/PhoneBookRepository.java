/**
 * 
 */
package com.sivalabs.phonebook;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.common.model.User;

/**
 * @author K. Siva Prasad Reddy
 *
 */
@Repository
@Transactional
public class PhoneBookRepository
{
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	public Integer create(Contact contact)
	{
		User user = this.entityManager.find(User.class, contact.getUser().getUserId());
		contact.setUser(user);
		user.getContacts().add(contact);
		this.entityManager.persist(contact);
		return contact.getId();
	}
	
	public Set<Contact> getContacts(Integer userId)
	{
		User user = this.entityManager.find(User.class, userId);
		return user.getContacts();
	}
}
