/**
 * 
 */
package com.sivalabs.forum.services;

import java.util.Collection;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.forum.domain.Forum;
import com.sivalabs.forum.domain.Post;
import com.sivalabs.forum.domain.Topic;
import com.sivalabs.forum.domain.User;

/**
 * @author siva
 *
 */
@Service
@Transactional
public class ForumService extends AbstractService
{
	public Collection<Forum> getForums()
	{
		return this.getDaoFactory().getForumDAO().getAll();
	}
	
	public Forum getForum(long forumId)
	{
		Forum forum = this.getDaoFactory().getForumDAO().getById(forumId);
		//forum.setTopics(this.getTopics(forumId));
		return forum;
	}
	
	public Collection<Topic> getTopics(long forumId)
	{
		return this.getDaoFactory().getTopicDAO().getForumTopics(forumId);
	}
		
	public Topic getTopic(long topicId)
	{
		Topic topic = this.getDaoFactory().getTopicDAO().getById(topicId);
		//topic.setPosts(this.getPosts(topicId));
		return topic;
	}
	
	public Collection<Post> getPosts(long topicId)
	{
		return this.getDaoFactory().getPostDAO().getPosts(topicId);
	}
	
	public Post getPost(long postId)
	{
		return this.getDaoFactory().getPostDAO().getById(postId);
	}

	public Topic createTopic(Topic topic)
	{
		Post post = new Post();
		post.setTitle(topic.getTitle());
		post.setMessage(topic.getMessage());
		post.setPostedBy(topic.getStartedBy());
		post.setPostedOn(new Date());
		post.setTopic(topic);
		
		Forum forum = this.getForum(topic.getForum().getForumId());
		topic.setForum(forum);
		topic.getPosts().add(post);
		
		forum.getTopics().add(topic);
		forum.incrementTopicsCount();
		forum.setLastTopic(topic);
		
		System.out.println("New Topic Id="+topic.getTopicId());
		return topic;
	}
	
	@Deprecated
	public Topic createTopic(long forumId, Post post)
	{
		
		Topic topic = new Topic();
		topic.setPostedOn(new Date());
		User user = new User();
		user.setUserId(1);
		topic.setStartedBy(user);
		topic.setTitle(post.getTitle());
		
		Forum forum = this.getForum(forumId);
		topic.setForum(forum);
		forum.getTopics().add(topic);
		
		post.setPostedOn(new Date());
		post.setTopic(topic);
		
		topic.getPosts().add(post);
		
		System.out.println("New Topic Id="+topic.getTopicId());
		return topic;
	}

	public long createPost(Post post) 
	{
		Topic topic = this.getTopic(post.getTopic().getTopicId());
		post.setTopic(topic);
		long postId = this.getDaoFactory().getPostDAO().create(post);
		topic.incrementRepliesCount();
		topic.setLastPost(post);
		return postId;
	}
	
}
