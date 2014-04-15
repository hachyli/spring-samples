/**
 * 
 */
package com.sivalabs.core.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Siva
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
