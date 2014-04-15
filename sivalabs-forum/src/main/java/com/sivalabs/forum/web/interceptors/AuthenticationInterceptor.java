/**
 * 
 */
package com.sivalabs.forum.web.interceptors;

/**
 * @author skatam
 *
 */

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sivalabs.forum.domain.User;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter
{
	private static Set<String> SECURE_ACTIONS = new HashSet<String>()	;
	{
		SECURE_ACTIONS.add("newTopic");
		SECURE_ACTIONS.add("reply");
		
	};

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception
	{
		String uri = request.getRequestURI();
		String contextRoot = request.getContextPath();
		System.out.println("URL------->"+request.getRequestURL());
		String action = StringUtils.trimToEmpty(uri.substring(contextRoot.length()+1));
		System.out.println("action="+action);
		
		if(action.endsWith("login.do") || action.endsWith("logout.do") || action.endsWith("createUser.do") ){
			return true;
		}
		else if (isSecureAction(action))
		{
			User userData = (User) request.getSession().getAttribute("LOGGEDIN_USER");
			if (userData == null)
			{
				response.sendRedirect(contextRoot+"/login.do");
				return false;
			}
		}
		return true;
	}
	
	private static final boolean isSecureAction(String url){
		for (String action : SECURE_ACTIONS) 
		{
			if(url.contains(action))
			{
				return true;
			}
		}
		return false;
	}
}
