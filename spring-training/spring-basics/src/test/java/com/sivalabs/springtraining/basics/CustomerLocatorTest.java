/**
 * 
 */
package com.sivalabs.springtraining.basics;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Siva
 *
 */
public class CustomerLocatorTest 
{
	private static ApplicationContext ctx;
	
	@BeforeClass
	public static void init() {
		ctx = new ClassPathXmlApplicationContext("applicationContext-test.xml");
	}
	
	@AfterClass
	public static void destroy() {
		ctx = null;
	}
	
	@Test
	public void testGetCustomersWithLocations() {
		CustomerLocator locator = ctx.getBean(CustomerLocator.class);
		List<Customer> customers = locator.getCustomersWithLocations();
		for (Customer customer : customers) {
			System.err.println(customer.getName()+
					" Latitude: "+customer.getAddress().getLatitude()+
					", Longitude: "+customer.getAddress().getLongitude());
		}
	}
}
