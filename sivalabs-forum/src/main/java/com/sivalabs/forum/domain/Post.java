/**
 * 
 */
package com.sivalabs.forum.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author skatam
 *
 */
@Entity
@Table(name="posts")
public class Post extends DomainObject 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="post_id") private long postId;
	@Column(name="title")private String title;
	@Column(name="message")private String message;
	//@Column(name="topic_id")private long topicId;
	//@Column(name="posted_by")private long postedBy;
	
	@OneToOne
	@JoinColumn(name="posted_by")
	private User postedBy;
	
	@Column(name="posted_on")private Date postedOn;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="topic_id")
	private Topic topic;
	
	public long getPostId()
	{
		return postId;
	}
	public void setPostId(long postId)
	{
		this.postId = postId;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	/*
	public long getTopicId()
	{
		return topicId;
	}
	public void setTopicId(long topicId)
	{
		this.topicId = topicId;
	}
	*/
	public User getPostedBy()
	{
		return postedBy;
	}
	public void setPostedBy(User postedBy)
	{
		this.postedBy = postedBy;
	}
	public Date getPostedOn()
	{
		return postedOn;
	}
	public void setPostedOn(Date postedOn)
	{
		this.postedOn = postedOn;
	}
	public Topic getTopic()
	{
		return topic;
	}
	public void setTopic(Topic topic)
	{
		this.topic = topic;
	}
	
}
