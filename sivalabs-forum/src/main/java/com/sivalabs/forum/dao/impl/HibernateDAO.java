/**
 * 
 */
package com.sivalabs.forum.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author skatam
 *
 */
public abstract class HibernateDAO
{
	private SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
}
