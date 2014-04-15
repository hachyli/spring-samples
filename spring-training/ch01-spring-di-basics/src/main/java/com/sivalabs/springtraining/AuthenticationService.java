/**
 * 
 */
package com.sivalabs.springtraining;


/**
 * @author Siva
 *
 */
public class AuthenticationService {
	private Authenticator authenticator = null;
	//private static AuthenticationService instance = new AuthenticationService();
	
	/*private AuthenticationService() {
	}*/
	private AuthenticationService(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
	
	
	/*public static AuthenticationService getInstance() {
		return instance;
	}*/	
	
	public static AuthenticationService getInstance(Authenticator authenticator) {
		return new AuthenticationService(authenticator);
	}
	
	
	public String login(String user, String pwd)
	{
		System.out.println("Authenticating  "+user);
		return authenticator.authenticate(user, pwd);
	}
}
