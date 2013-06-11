/**
 * 
 */
package com.sivalabs.buzz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sivalabs.buzz.entities.User;

/**
 * @author Siva
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{

}
