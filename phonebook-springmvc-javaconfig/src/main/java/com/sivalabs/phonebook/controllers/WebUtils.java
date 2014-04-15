/**
 * 
 */
package com.sivalabs.phonebook.controllers;

import javax.servlet.http.HttpServletRequest;

import com.sivalabs.phonebook.entities.User;
 
/**
 * @author siva
 *
 */
public class WebUtils {
	private static final String LOGIN_USER = "LOGIN_USER";
	
	public static void setLoginUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute(LOGIN_USER, user);
	}
	
	public static User getLoginUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(LOGIN_USER);
	}
}
