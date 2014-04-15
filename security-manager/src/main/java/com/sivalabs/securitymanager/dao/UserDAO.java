/**
 * 
 */
package com.sivalabs.securitymanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sivalabs.securitymanager.domain.User;


/**
 * @author siva
 *
 */
public interface UserDAO extends JpaRepository<User, Integer>
{
	@Query("select u from User u where userName=?1 and password=?2")
	User login(String userName, String password);
	
}
