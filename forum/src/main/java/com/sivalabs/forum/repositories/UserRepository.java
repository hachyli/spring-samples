/**
 * 
 */
package com.sivalabs.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sivalabs.forum.entities.User;

/**
 * @author Siva
 *
 */
public interface UserRepository extends JpaRepository<User, Long>
{

	User findUserByUsername(String username);

	User findUserByEmail(String email);
	
	@Query("select u from User u where u.username=?1 and u.password=?2 and (u.disabled = null or u.disabled=0)")
	User login(String username, String password);

	@Query("select count(u) from User u where u.username=?1")
	Long isUsernameExists(String username);
	
	@Query("select count(u) from User u where u.email=?1")
	Long isEmailExists(String email);
	

}
