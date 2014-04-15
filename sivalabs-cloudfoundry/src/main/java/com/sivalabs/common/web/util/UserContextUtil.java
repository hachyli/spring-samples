/**
 * 
 */
package com.sivalabs.common.web.util;

import javax.servlet.http.HttpSession;

import com.sivalabs.common.model.User;
import com.sivalabs.common.model.UserContext;

/**
 * @author K. Siva Prasad Reddy
 *
 */
public class UserContextUtil
{
	private static final String USER_CONTEXT_KEY = "USER_CONTEXT_KEY";
	
	public static void initUserContext(HttpSession httpSession, User user)
	{
		if(httpSession == null || user == null){
			throw new IllegalArgumentException();
		}
		UserContext userContext = new UserContext();
		userContext.setUser(user);
		httpSession.setAttribute(USER_CONTEXT_KEY, userContext);
	}
	
	public static UserContext getUserContext(HttpSession httpSession)
	{
		return (UserContext) httpSession.getAttribute(USER_CONTEXT_KEY);
	}

	public static User getLoggedinUser(HttpSession session)
	{
		UserContext userContext = getUserContext(session);
		return (userContext == null)? null : userContext.getUser();
	}
	
}
