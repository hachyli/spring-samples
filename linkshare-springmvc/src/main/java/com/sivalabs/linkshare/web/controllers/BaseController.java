/**
 * 
 */
package com.sivalabs.linkshare.web.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.sivalabs.linkshare.UserNotLoggedinException;
import com.sivalabs.linkshare.entities.User;
import com.sivalabs.linkshare.services.LinkShareService;

/**
 * @author skatam
 *
 */

public class BaseController 
{
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String LOGIN_USER_KEY = "LOGIN_USER";
	
	@Autowired
	private LinkShareService linkShareService;
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, 
		    ServletRequestDataBinder binder) throws Exception 
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    df.setLenient(false);
	    CustomDateEditor editor = new CustomDateEditor(df, true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	public LinkShareService getLinkShareService() {
		return linkShareService;
	}
	

	
	public static User getLoggedInUser(HttpSession session) {
		User loginUser = (User) session.getAttribute(LOGIN_USER_KEY);
		//logger.debug("loginUser :"+loginUser);
		if(loginUser == null)
		{
			throw new UserNotLoggedinException();
		}
		return loginUser;
	}
	
	public static void setLoggedInUser(HttpSession session, User user) {
		session.setAttribute(LOGIN_USER_KEY, user);
	}
	
	public static boolean isUserLoggedIn(HttpSession session) {
		return (session.getAttribute(LOGIN_USER_KEY) != null);
	}
}
