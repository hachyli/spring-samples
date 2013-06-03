/**
 * 
 */
package com.sivalabs.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.forum.entities.Topic;

/**
 * @author Siva
 *
 */
public interface TopicRepository extends JpaRepository<Topic, Long>
{

	

}
