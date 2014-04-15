/**
 * 
 */
package com.sivalabs.forum.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.sivalabs.forum.dao.DAOFactory;

/**
 * @author siva
 *
 */
public abstract class AbstractService
{
	private DAOFactory daoFactory;
	@Autowired
	public void setDaoFactory(DAOFactory daoFactory)
	{
		this.daoFactory = daoFactory;
	}
	protected DAOFactory getDaoFactory()
	{
		return daoFactory;
	}
	
	
}
