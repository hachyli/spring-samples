/**
 * 
 */
package com.sivalabs.springsecurity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siva
 *
 */
public class DomainUser
{
	private int id;
	private String email;
	private String password;
	private boolean disabled;
	
	private List<String> roles = new ArrayList<>();
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public List<String> getRoles()
	{
		return roles;
	}
	public void setRoles(List<String> roles)
	{
		this.roles = roles;
	}
	public boolean isDisabled()
	{
		return disabled;
	}
	public void setDisabled(boolean disabled)
	{
		this.disabled = disabled;
	}
	
	
}
