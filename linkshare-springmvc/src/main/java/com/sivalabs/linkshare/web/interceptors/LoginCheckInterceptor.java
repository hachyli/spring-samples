/**
 * 
 */
package com.sivalabs.linkshare.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sivalabs.linkshare.UserNotLoggedinException;
import com.sivalabs.linkshare.entities.User;

/**
 * @author skatam
 *
 */
//@Component
public class LoginCheckInterceptor extends HandlerInterceptorAdapter
{
	private static final Logger logger = LoggerFactory.getLogger(LoginCheckInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		logger.debug("Request Path :"+ path);
		boolean go = true;
		if (path.startsWith("/secure/")) 
		{
			logger.debug("Secured URL : "+uri);
			User userData;
			try {
				userData =  (User) request.getSession().getAttribute("LOGIN_USER");
				if (userData == null) {
					go = false;
				}
			} catch (UserNotLoggedinException e) {
				logger.debug("User not loggedin");
				go = false;
			}
			if(!go){
				logger.debug("User not loggedin. Redirecting to Login screen.");
				response.sendRedirect("../login.htm");
			}
		}
		
		return go;
	}
	
}
