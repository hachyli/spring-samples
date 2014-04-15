/**
 * 
 */
package com.sivalabs.forum.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author siva
 *
 */
@Repository
public class DAOFactory
{
	private UserDAO userDAO;
	private ForumDAO forumDAO;
	private TopicDAO topicDAO;
	private PostDAO postDAO;
	
	@Autowired
	public void setUserDAO(UserDAO userDAO)	{this.userDAO = userDAO;}
	public UserDAO getUserDAO(){return userDAO;}
	
	
	public ForumDAO getForumDAO()
	{
		return forumDAO;
	}
	@Autowired
	public void setForumDAO(ForumDAO forumDAO)
	{
		this.forumDAO = forumDAO;
	}
	public TopicDAO getTopicDAO()
	{
		return topicDAO;
	}
	@Autowired
	public void setTopicDAO(TopicDAO topicDAO)
	{
		this.topicDAO = topicDAO;
	}
	public PostDAO getPostDAO()
	{
		return postDAO;
	}
	@Autowired
	public void setPostDAO(PostDAO postDAO)
	{
		this.postDAO = postDAO;
	}
	
	
}
