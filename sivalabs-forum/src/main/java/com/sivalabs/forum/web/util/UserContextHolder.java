/**
 * 
 */
package com.sivalabs.forum.web.util;

import javax.servlet.http.HttpSession;

import com.sivalabs.forum.domain.User;

/**
 * @author siva
 *
 */
public class UserContextHolder 
{
	private static final String LOGGEDIN_USER_KEY = "LOGGEDIN_USER_KEY";
	
	public static void setLoggedinUser(HttpSession session, User user) 
	{
		session.setAttribute(LOGGEDIN_USER_KEY, user);
	}
	
	public static User getLoggedinUser(HttpSession session) 
	{
		return (User) session.getAttribute(LOGGEDIN_USER_KEY);
	}
	
	public static User getMandatoryLoggedinUser(HttpSession session) 
	{
		User user = (User) session.getAttribute(LOGGEDIN_USER_KEY);
		if(user==null){
			throw new UserNotLoggedinException();
		}
		return user;
	}
	
	
	
}
