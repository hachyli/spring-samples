/**
 * 
 */
package com.sivalabs.phonebook.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.phonebook.entities.Contact;
import com.sivalabs.phonebook.entities.User;
 
/**
 * @author siva
 *
 */
@Service
@Transactional
public class PhonebookService 
{
	@PersistenceContext()
	private EntityManager em;
	
	public void addContact(Integer userId, Contact contact) {
		User user = em.find(User.class, userId);
		user.getContacts().add(contact);
	}
	public void addContacts(Integer userId, Contact... contacts) {
		User user = em.find(User.class, userId);
		for (Contact contact : contacts) {
			user.getContacts().add(contact);
		}
	}
	
	public Contact getContactById(Integer contactId) {
		return em.find(Contact.class, contactId);
	}
	
	public List<Contact> getUserContacts(Integer userId) {
		User user = em.find(User.class, userId);
		if(user != null){
			return user.getContacts();
		}
		return null;
	}

	public List<Contact> searchUserContacts(Integer userId, String searchName) {
		TypedQuery<Contact> query = em.createQuery("select c from Contact c where c.user.userId=?1 " +
						" and (c.firstName like ?2 or c.lastName like ?3)",
						Contact.class);
		query.setParameter(1, userId);
		query.setParameter(2, searchName+"%");
		query.setParameter(3, searchName+"%");
		
		return query.getResultList();
	}
	
	public void updateContact(Contact contact) {
		em.merge(contact);
	}
	
	public void deleteContact(Integer contactId) {
		Contact contact = em.find(Contact.class, contactId);
		if(contact != null){
			User user = em.find(User.class, contact.getUser().getUserId());
			user.getContacts().remove(contact);
			System.err.println("contact:"+contact);
		
			em.remove(contact);
		}
	}
	
}
