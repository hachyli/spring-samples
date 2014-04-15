/**
 * 
 */
package com.sivalabs.springtraining;

/**
 * @author Siva
 *
 */
public class AdminService extends AbstractBaseService
{
	private UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
		
	}
	
	public String getAdminEmail() {
		return userDAO.getAdminEmail();
	}
	
	public void doTask(String task) {
		getCommonDAO().doCommonTask(task);
	}
}
