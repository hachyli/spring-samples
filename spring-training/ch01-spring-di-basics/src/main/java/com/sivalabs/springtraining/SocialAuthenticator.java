/**
 * 
 */
package com.sivalabs.springtraining;

/**
 * @author Siva
 *
 */
public class SocialAuthenticator implements Authenticator{

	@Override
	public String authenticate(String username, String pwd) {
		System.out.println("Authenticating using Social Authenticator");
		return username;
	}

}
