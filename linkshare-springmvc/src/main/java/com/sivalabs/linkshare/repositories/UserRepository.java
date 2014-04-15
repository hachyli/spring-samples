/**
 * 
 */
package com.sivalabs.linkshare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sivalabs.linkshare.entities.User;
import com.sivalabs.linkshare.entities.UserLogon;

/**
 * @author skatam
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	@Query("select u from UserLogon u where u.username=?1 and u.password=?2")
	UserLogon login(String userName, String password);

}
