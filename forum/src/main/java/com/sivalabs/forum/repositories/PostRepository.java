/**
 * 
 */
package com.sivalabs.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.forum.entities.Post;

/**
 * @author Siva
 *
 */
public interface PostRepository extends JpaRepository<Post, Long>
{

	
}
