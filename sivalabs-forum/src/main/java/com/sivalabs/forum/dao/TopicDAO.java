/**
 * 
 */
package com.sivalabs.forum.dao;

import java.util.Collection;

import com.sivalabs.forum.domain.Topic;

/**
 * @author siva
 *
 */
public interface TopicDAO extends GenericDAO<Topic, Long>
{
	public Collection<Topic> getForumTopics(long forumId);	
}
