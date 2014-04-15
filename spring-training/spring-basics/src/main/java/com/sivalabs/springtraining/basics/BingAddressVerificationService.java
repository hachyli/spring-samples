/**
 * 
 */
package com.sivalabs.springtraining.basics;

/**
 * @author Siva
 *
 */
public class BingAddressVerificationService implements AddressVerificationService {

	
	@Override
	public void verify(Address address) {
		System.err.println("****** verifying address using BingAddressVerificationService ***************");
		address.setLongitude("820.50");
		address.setLatitude("-625.60");
	}

}
