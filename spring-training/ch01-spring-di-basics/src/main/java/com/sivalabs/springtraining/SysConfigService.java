/**
 * 
 */
package com.sivalabs.springtraining;

/**
 * @author Siva
 *
 */
public class SysConfigService {
	private CommonDAO commonDAO;
	private Authenticator authenticator;
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}
	public void doTask(String task) {
		commonDAO.doCommonTask(task);
	}
	public String authenticate(String username, String pwd) {
		return authenticator.authenticate(username, pwd);
	}
}
