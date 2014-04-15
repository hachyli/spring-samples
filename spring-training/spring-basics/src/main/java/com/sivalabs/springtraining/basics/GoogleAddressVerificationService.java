/**
 * 
 */
package com.sivalabs.springtraining.basics;

/**
 * @author Siva
 *
 */
public class GoogleAddressVerificationService implements AddressVerificationService {

	
	@Override
	public void verify(Address address) {
		System.err.println("****** verifying address using GoogleAddressVerificationService ***************");
		address.setLongitude("1002.00");
		address.setLatitude("-45.36");
	}

}
