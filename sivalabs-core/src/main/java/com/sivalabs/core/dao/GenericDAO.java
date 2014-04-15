/**
 * 
 */
package com.sivalabs.core.dao;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author Siva Prasad Reddy
 *
 */
public interface GenericDAO<T, ID extends Serializable>
{
	public ID create(T obj);
	public T getById(ID id);
	public Collection<T> getAll();
	public void update(T obj);
	public void delete(T obj);
	public void deleteById(ID id);
}
