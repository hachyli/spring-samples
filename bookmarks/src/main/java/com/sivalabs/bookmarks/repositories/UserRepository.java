/**
 * 
 */
package com.sivalabs.bookmarks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sivalabs.bookmarks.entities.User;

/**
 * @author Siva
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	@Query("select u from User u where userName=?1 and password=?2")
	User login(String userName, String password);

}
