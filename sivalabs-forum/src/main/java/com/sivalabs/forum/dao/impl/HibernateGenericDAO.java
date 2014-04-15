/**
 * 
 */
package com.sivalabs.forum.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import com.sivalabs.forum.dao.GenericDAO;

/**
 * @author skatam
 * @param <T>
 * @param <ID>
 *
 */
public class HibernateGenericDAO<T, ID extends Serializable> extends HibernateDAO implements GenericDAO<T, ID> 
{
	private Class<T> type;

    @SuppressWarnings("unchecked")
	public HibernateGenericDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
	
	
	@SuppressWarnings("unchecked")
	@Override
	public ID create(T obj)
	{
		return (ID) this.getSession().save(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(ID id)
	{
		return (T) this.getSession().get(type, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<T> getAll()
	{
		return this.getSession().createCriteria(type).list();
	}

	@Override
	public void update(T obj)
	{
		this.getSession().update(obj);
	}

	@Override
	public void delete(T obj)
	{
		this.getSession().delete(obj);		
	}

	@Override
	public void deleteById(ID id)
	{
		T obj = this.getById(id);
		this.delete(obj);		
	}

}
