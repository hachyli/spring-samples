/**
 * 
 */
package com.sivalabs.forum.dao;

import java.util.Collection;

import com.sivalabs.forum.domain.Post;

/**
 * @author siva
 *
 */
public interface PostDAO extends GenericDAO<Post, Long>
{
	public Collection<Post> getPosts(long topicId);
}
