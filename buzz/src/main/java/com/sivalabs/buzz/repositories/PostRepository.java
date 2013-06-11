/**
 * 
 */
package com.sivalabs.buzz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sivalabs.buzz.entities.Post;

/**
 * @author Siva
 *
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

	List<Post> findByCreatedById(int userId);

}
