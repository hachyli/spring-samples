/**
 * 
 */
package com.sivalabs.springtraining;

/**
 * @author Siva
 *
 */
public class UserController {

	private UserService userService;
	
	private AuthenticationService authenticationService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setAuthenticationService(
			AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	
	public String getAdminEmail() {
		return userService.getAdminEmail();
	}
	
	public String login(String user, String pwd) {
		return authenticationService.login(user, pwd);
	}
}
