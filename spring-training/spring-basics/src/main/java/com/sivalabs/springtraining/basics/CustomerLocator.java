/**
 * 
 */
package com.sivalabs.springtraining.basics;

import java.util.List;

/**
 * @author Siva
 *
 */
public class CustomerLocator 
{
	private CustomerDataProvider customerDataProvisder;
	private AddressVerificationService addressVerificationService;
	
	public void setCustomerDataProvisder(
			CustomerDataProvider customerDataProvisder) {
		this.customerDataProvisder = customerDataProvisder;
	}
	
	public void setAddressVerificationService(
			AddressVerificationService addressVerificationService) {
		this.addressVerificationService = addressVerificationService;
	}
	
	public List<Customer> getCustomersWithLocations() 
	{
		List<Customer> customers = customerDataProvisder.getCustomerData();
		for (Customer customer : customers) {
			addressVerificationService.verify(customer.getAddress());
		}
		return customers;
		
	}
}
