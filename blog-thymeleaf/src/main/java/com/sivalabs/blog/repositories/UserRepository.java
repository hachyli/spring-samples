/**
 * 
 */
package com.sivalabs.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sivalabs.blog.entities.User;

/**
 * @author Siva
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
