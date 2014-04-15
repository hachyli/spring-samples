/**
 * This software is developed by author of http://sivalabs.blogspot.com.
 * This is a freeware. You can use it, change it, redistribute it.
 */
package com.sivalabs.securitymanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author K. Siva Prasad Reddy
 * Date  : Aug 9, 2011
 *
 */
@Entity
public class Privilege
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int privilegeId;
	private String privilegeName;
	private int applicationId;
	private String description;
	private boolean active;
	
	public Privilege()
	{
	}
	
	public Privilege(int privilegeId, String privilegeName, int applicationId,
			String description, boolean active)
	{
		super();
		this.privilegeId = privilegeId;
		this.privilegeName = privilegeName;
		this.applicationId = applicationId;
		this.description = description;
		this.active = active;
	}

	public int getPrivilegeId()
	{
		return privilegeId;
	}
	public void setPrivilegeId(int privilegeId)
	{
		this.privilegeId = privilegeId;
	}
	public String getPrivilegeName()
	{
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName)
	{
		this.privilegeName = privilegeName;
	}
	public int getApplicationId()
	{
		return applicationId;
	}
	public void setApplicationId(int applicationId)
	{
		this.applicationId = applicationId;
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
	
}
