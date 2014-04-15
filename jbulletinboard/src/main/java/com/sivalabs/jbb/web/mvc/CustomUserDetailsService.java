/**
 * 
 */
package com.sivalabs.jbb.web.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sivalabs.jbb.web.mvc.domain.AuthenticatedUser;

/**
 * @author Siva
 *
 */
@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		com.sivalabs.jbb.web.mvc.domain.User user = authenticationService.getUserByUsername(username);
		AuthenticatedUser authenticatedUser = AuthenticatedUser.build(user);
		return authenticatedUser;
	}
	
	/*
	protected UserDetails getUserDetails(String username)
	{
		UserDetails userDetails = null;
		if("admin".equals(username))
		{
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			userDetails = new User(username, "admin", authorities );
		} else if("siva".equals(username))
		{
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			userDetails = new User(username, "siva", authorities );
		} else{
			throw new UsernameNotFoundException("Invalid UserName and Password.");
		}
		
		return userDetails;
	}
	*/

}
