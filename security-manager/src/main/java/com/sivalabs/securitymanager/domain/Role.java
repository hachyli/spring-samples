/**
 * This software is developed by author of http://sivalabs.blogspot.com.
 * This is a freeware. You can use it, change it, redistribute it.
 */
package com.sivalabs.securitymanager.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author K. Siva Prasad Reddy
 * Date  : Aug 9, 2011
 *
 */
@Entity
public class Role
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleId;
	private String roleName;
	private int appId;
	private String description;
	private boolean active;
	
	@Transient
	private Set<Privilege> privileges = new HashSet<Privilege>();
	
	public Role()
	{
	}
	public Role(int roleId, String roleName, int appId, String description,
			boolean active)
	{
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.appId = appId;
		this.description = description;
		this.active = active;
	}
	public int getRoleId()
	{
		return roleId;
	}
	public void setRoleId(int roleId)
	{
		this.roleId = roleId;
	}
	public String getRoleName()
	{
		return roleName;
	}
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
	public int getAppId()
	{
		return appId;
	}
	public void setAppId(int appId)
	{
		this.appId = appId;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public boolean isActive()
	{
		return active;
	}
	public void setActive(boolean active)
	{
		this.active = active;
	}
	
	public Set<Privilege> getPrivileges()
	{
		return privileges;
	}
	
	public void setPrivileges(Set<Privilege> privileges)
	{
		this.privileges = privileges;
	}
}
