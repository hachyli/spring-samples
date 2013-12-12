package com.sivalabs.blogger.domain;

import java.util.Date;

/**
 * @author Siva
 * 
 */
public abstract class BaseEntity
{
	private int id;
	private Date createdOn;
	private Date updatedOn;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Date getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn()
	{
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn)
	{
		this.updatedOn = updatedOn;
	}

}
