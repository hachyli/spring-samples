/**
 * 
 */
package com.sivalabs.springtraining.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Siva
 *
 */
public class InMemoryCustomerDataProvider implements CustomerDataProvider{

	private static final List<Customer> customers = new ArrayList<>();
	
	public InMemoryCustomerDataProvider() 
	{
		Customer customer1 = new Customer(1, "Siva", new Address("Kukatpally","Hyderabad","AP","500082","India",null,null));
		Customer customer2 = new Customer(2, "Prasad", new Address("Kukatpally","Hyderabad","AP","500082","India",null,null));
		Customer customer3 = new Customer(3, "Reddy", new Address("Kukatpally","Hyderabad","AP","500082","India",null,null));
		
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		
	}
	
	@Override
	public List<Customer> getCustomerData() {
		return Collections.unmodifiableList(customers);
	}

}
