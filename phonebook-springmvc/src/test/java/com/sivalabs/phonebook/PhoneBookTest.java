package com.sivalabs.phonebook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.phonebook.entities.Contact;
import com.sivalabs.phonebook.entities.User;
import com.sivalabs.phonebook.services.PhonebookService;
import com.sivalabs.phonebook.services.UserService;


/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class PhoneBookTest 
{
    @Autowired
	private UserService userService;
    @Autowired
	private PhonebookService phonebookService;
    
    @Test
    public void testCreateUser() {
		User user = new User();
		user.setUserName("skatam");
		user.setPassword("skatam");
		user.setFirstName("Sivaprasad");
		user.setLastName("K");
		user.setEmailId("siva@gmail.com");
		
		Integer userId = userService.saveUser(user);
		System.out.println(userId);
		
	}
    //@Test
    public void testAddContact() {
		Contact contact = new Contact();
		contact.setFirstName("Neha");
		contact.setLastName("Jain");
		contact.setEmailId("neha@gmail.com");
		
	}
}
