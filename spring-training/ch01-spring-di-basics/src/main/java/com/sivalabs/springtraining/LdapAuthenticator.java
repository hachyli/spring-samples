/**
 * 
 */
package com.sivalabs.springtraining;

/**
 * @author Siva
 *
 */
public class LdapAuthenticator implements Authenticator{

	@Override
	public String authenticate(String username, String pwd) {
		System.out.println("Authenticating using LDAP Authenticator");
		return username;
	}

}
