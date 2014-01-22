/**
 * 
 */
package com.sivalabs.ebuddy.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sivalabs.ebuddy.entities.Contact;
import com.sivalabs.ebuddy.entities.Role;
import com.sivalabs.ebuddy.entities.User;
import com.sivalabs.ebuddy.services.UserService;

/**
 * @author Siva
 * 
 */
@Component
public class DBInitializer
{
	private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	@Autowired
	private UserService userService;

	@Value("${init-db:false}")
	private String initDatabase;

	@PostConstruct
	public void init()
	{
		try {
			logger.info("############## InitDatabase :" + initDatabase + " ########################");
			if (Boolean.parseBoolean(initDatabase)) {
				initDatabase();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void initDatabase()
	{

		logger.info("Initializing Database with sample data");
		
		Role role1 = new Role("ROLE_USER");
		Role role2 = new Role("ROLE_ADMIN");
		
		User user1 = new User(1, "admin@gmail.com", "admin", "Administrator");
		User user2 = new User(2, "sivaprasadreddy.k@gmail.com", "siva", "Siva");
		
		user1.addRoles(role1, role2);
		user2.addRoles(role1);
		
		
		Contact contact1 = new Contact(null,"Prasad","Reddy","9999999999999");
		Contact contact2 = new Contact(null,"Siva","Reddy","888888888888");
		Contact contact3 = new Contact(null,"SivaPrasad","Reddy","77777777777777");
		
		user1.addContacts(contact3);
		contact3.setUser(user1);
		
		user2.addContacts(contact1, contact2);
		contact1.setUser(user2);
		contact2.setUser(user2);
		
		userService.createUser(user1);
		userService.createUser(user2);
		
	}
}
