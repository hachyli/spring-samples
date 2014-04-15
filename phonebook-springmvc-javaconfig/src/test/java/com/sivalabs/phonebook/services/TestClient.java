/**
 * 
 */

package com.sivalabs.phonebook.services;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sivalabs.phonebook.config.ComponentConfig;
import com.sivalabs.phonebook.config.PersistenceConfig;
import com.sivalabs.phonebook.config.ServicesConfig;
import com.sivalabs.phonebook.entities.Contact;
import com.sivalabs.phonebook.entities.User;
import com.sivalabs.phonebook.utils.CommonUtils;

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
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ComponentConfig.class, ServicesConfig.class, PersistenceConfig.class);
		
		ctx.refresh();
		UserService userService = ctx.getBean(UserService.class);
		PhonebookService phonebookService = ctx.getBean(PhonebookService.class);
		
		Integer userId = 2;
		User user = userService.getUser(userId);
		
		/*User user = new User();
		user.setUserName("guest");
		user.setPassword("guest");
		user.setFirstName("Guest");*/
		
		Contact contact = new Contact();
		contact.setFirstName("Nidhi");
		contact.setLastName("Jain");
		contact.setEmailId("Nidhi@gmail.com");
		contact.setUser(user);
		
		user.getContacts().add(contact);
		
		//phonebookService.addContact(1, contact);
		//userId = userService.saveUser(user);
		
		List<Contact> contacts = phonebookService.searchUserContacts(userId, "");
		for (Contact contact2 : contacts) {
			//System.err.println(contact2);
			CommonUtils.print(contact2);
		}
		
		//phonebookService.deleteContact(5);
		
	}

}
