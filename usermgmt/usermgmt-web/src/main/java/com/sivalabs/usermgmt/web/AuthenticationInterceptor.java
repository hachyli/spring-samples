package com.sivalabs.usermgmt.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sivalabs.usermgmt.entities.User;

//@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		//System.out.println(contextPath);
		String requestMapping = uri.substring(contextPath.length()+1);
		if (!requestMapping.startsWith("services/") 
				&& !requestMapping.startsWith("rest/")
				&& !requestMapping.startsWith("login.htm") 
				&& !requestMapping.startsWith("logout.htm")) {
			User userData = (User) request.getSession().getAttribute("LOGIN_USER");
			if (userData == null) {
				response.sendRedirect("login.htm");
				return false;
			}
		}
		return true;
	}
}