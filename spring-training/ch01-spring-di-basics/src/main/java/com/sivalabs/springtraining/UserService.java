/**
 * 
 */
package com.sivalabs.springtraining;


/**
 * @author Siva
 *
 */
public class UserService {
	private UserDAO userDAO;

	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String getAdminEmail() {
		return userDAO.getAdminEmail();
	}
	
}
