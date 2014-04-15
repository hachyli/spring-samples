package com.sivalabs.jbb.web.mvc.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.sivalabs.jbb.entities.Role;

/**
 * @author Siva
 *
 */
public class AuthenticatedUser extends org.springframework.security.core.userdetails.User
{
	private static final long serialVersionUID = 1L;
	
	public static AuthenticatedUser build(User user)
	{
		return new AuthenticatedUser
				(user.getUserName(), user.getPassword(), true, true, true,
				true, getUserAuthorities(user));
		
	}
	private static Collection<? extends GrantedAuthority> getUserAuthorities(
			User user)
	{
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Set<Role> roles = user.getRoles();
		for (Role role : roles)
		{
			GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
			authorities.add(authority);
		}
		return authorities;
	}
	public AuthenticatedUser(String username, String password, 
			Collection<? extends GrantedAuthority> authorities)
	{
		super(username, password, authorities);
	}
	
	public AuthenticatedUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities)
	{
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
	}
	
	

}
