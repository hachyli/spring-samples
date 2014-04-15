/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.core.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;


/**
 * @author K. Siva Prasad Reddy
 * Date : Aug 6, 2011
 */
public class HTTPUtils
{
	public static String getAbsolutePath(PageContext pageContext, String path)
	{
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		return  getAbsolutePath(request, path);
	}
	
	public static String getAbsolutePath(HttpServletRequest request, String path)
	{
		String contextRoot = request.getContextPath();
		String cleanPath = StringUtils.stripStartingChars(path, '/');
		return (contextRoot+"/"+cleanPath);
	}
	
	public static String getRelativePath(PageContext pageContext, String path)
	{
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		return  getRelativePath(request, path);
	}
	
	public static String getRelativePath(HttpServletRequest request, String path)
	{
		//String contextRoot = request.getContextPath();
		String uri = request.getRequestURI();
		//StringBuffer url = request.getRequestURL();
		//System.out.println(uri);
		//System.out.println(url);
		String cleanPath = uri.substring(0, uri.lastIndexOf('/'));
		return (cleanPath+path);
	}
	
	public static Object getRequestScopedAttributeValue(HttpServletRequest request, String attributeName)
	{
		return request.getAttribute(attributeName);
	}
	
	public static Object getSessionScopedAttributeValue(HttpServletRequest request, String attributeName)
	{
		return request.getSession().getAttribute(attributeName);
	}
	
	public static Object getSessionScopedAttributeValue(HttpSession session, String attributeName)
	{
		return session.getAttribute(attributeName);
	}
	
	public static void setSessionScopedAttributeValue(HttpServletRequest request, String attributeName, Object value)
	{
		request.getSession().setAttribute(attributeName, value);
	}
	
	public static void setSessionScopedAttributeValue(HttpSession session, String attributeName, Object value)
	{
		session.setAttribute(attributeName, value);
	}
}
