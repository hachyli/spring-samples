/**
 * 
 */
package com.sivalabs.phonebook.interceptors;

/**
 * @author siva
 *
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sivalabs.phonebook.entities.User;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter
{
 @Override
 public boolean preHandle(HttpServletRequest request,
   HttpServletResponse response, Object handler) throws Exception
 {
  String uri = request.getRequestURI();
  System.out.println(uri);
  if(!uri.endsWith("login.htm") && !uri.endsWith("registration.htm") && !uri.endsWith("logout.htm"))
  {
   User userData = (User) request.getSession().getAttribute("LOGIN_USER");
   if(userData == null)
   {
    response.sendRedirect("login.htm");
    return false;
   }   
  }
  return true;
 }
}

