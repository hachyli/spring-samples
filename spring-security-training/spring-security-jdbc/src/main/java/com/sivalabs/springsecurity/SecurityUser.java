/**
 * 
 */
package com.sivalabs.springsecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Siva
 *
 */
public class SecurityUser implements UserDetails
{
	private static final long serialVersionUID = 1L;
	
	private DomainUser domainUser;
	
	public SecurityUser(DomainUser user)
	{
		this.domainUser = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		List<String> roles = this.domainUser.getRoles();
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (String role : roles)
		{
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	@Override
	public String getPassword()
	{
		return domainUser.getPassword();
	}

	@Override
	public String getUsername()
	{
		return domainUser.getEmail();
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return !domainUser.isDisabled();
	}
	
}
