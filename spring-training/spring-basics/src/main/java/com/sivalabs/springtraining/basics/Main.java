/**
 * 
 */
package com.sivalabs.springtraining.basics;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Siva
 *
 */
public class Main {

	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CustomerLocator locator = ctx.getBean(CustomerLocator.class);
		List<Customer> customers = locator.getCustomersWithLocations();
		for (Customer customer : customers) {
			System.err.println(customer.getName()+
					" Latitude: "+customer.getAddress().getLatitude()+
					", Longitude: "+customer.getAddress().getLongitude());
		}
		
		
	}

}
