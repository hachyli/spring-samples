/**
 * 
 */
package com.sivalabs.springtraining;

/**
 * @author Siva
 *
 */
public class AuthenticatorFactory {

	private static Authenticator ldapAuthenticator = new LdapAuthenticator();
	private static Authenticator socialAuthenticator = new SocialAuthenticator();
	
	public Authenticator getLdapAuthenticator() {
		return ldapAuthenticator;
	}
	public Authenticator getSocialAuthenticator() {
		return socialAuthenticator;
	}
}
