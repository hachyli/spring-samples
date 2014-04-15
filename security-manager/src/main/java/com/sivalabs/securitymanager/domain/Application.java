/**
 * This software is developed by author of http://sivalabs.blogspot.com.
 * This is a freeware. You can use it, change it, redistribute it.
 */
package com.sivalabs.securitymanager.domain;

import javax.persistence.Column;
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
public class Application
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="app_id")
	private int appId;
	
	@Column(name="app_name")private String appName;
	@Column(name="description")private String description;
	@Column(name="active")private boolean active;
	
	public Application()
	{
	}
	public Application(int appId, String appName, String description,
			boolean active)
	{
		super();
		this.appId = appId;
		this.appName = appName;
		this.description = description;
		this.active = active;
	}
	
	public int getAppId()
	{
		return appId;
	}
	public void setAppId(int appId)
	{
		this.appId = appId;
	}
	public String getAppName()
	{
		return appName;
	}
	public void setAppName(String appName)
	{
		this.appName = appName;
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
