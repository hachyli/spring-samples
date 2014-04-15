/**
 * 
 */
package com.sivalabs.forum.dao;

import com.sivalabs.forum.domain.User;

/**
 * @author siva
 *
 */
public interface UserDAO extends GenericDAO<User, Integer>
{

	User login(String userName, String password);
	
}
