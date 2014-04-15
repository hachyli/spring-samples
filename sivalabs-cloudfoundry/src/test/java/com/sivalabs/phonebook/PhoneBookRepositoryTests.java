/**
 * 
 */
package com.sivalabs.phonebook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.common.model.User;

/**
 * @author K. Siva Prasad Reddy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
@ActiveProfiles("dev")
public class PhoneBookRepositoryTests
{
	@Autowired
	private PhoneBookRepository phoneBookRepository;
	
	@Test
	public void testSaveContact()
	{
		User user = new User();
		user.setUserId(3);
		Contact contact = new Contact();
		contact.setUser(user);
		contact.setFirstname("Siva3");
		contact.setLastname("K");
		contact.setEmailId("siva@gmail.com");
		contact.setPhone("1234");
		
		Integer id = phoneBookRepository.create(contact);
		System.out.println(id);
		
	}
}
