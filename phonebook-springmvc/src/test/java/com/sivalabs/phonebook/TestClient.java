/**
 * 
 */
package com.sivalabs.phonebook;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sivalabs.phonebook.entities.Contact;
import com.sivalabs.phonebook.entities.User;
import com.sivalabs.phonebook.services.PhonebookService;
import com.sivalabs.phonebook.services.UserService;

/**
 * @author siva
 *
 */
public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = ctx.getBean(UserService.class);
		PhonebookService phonebookService = ctx.getBean(PhonebookService.class);
		
		/*User user = userService.getUser(5);
		
		//User user = new User();
		user.setFirstName("Guest");
		Contact contact = new Contact();
		contact.setFirstName("Shaliniiiiii");
		contact.setLastName("Jain");
		contact.setEmailId("Shalini@gmail.com");
		contact.setUser(user);
		
		user.getContacts().add(contact);
		
		//phonebookService.addContact(1, contact);
		//userService.saveUser(user);
		
		List<Contact> contacts = phonebookService.searchUserContacts(1, "Ni");
		for (Contact contact2 : contacts) {
			System.err.println(contact2);
		}*/
		
		phonebookService.deleteContact(5);
		
	}

}
