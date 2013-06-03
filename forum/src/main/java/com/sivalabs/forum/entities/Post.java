package com.sivalabs.forum.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@Entity
@Table(name = "POSTS")
public class Post implements Serializable
{
	private static final long serialVersionUID = 1L;
	
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="topic_id")
    private Topic topic;
    @Column(nullable=false)
    private String title;
    private String content;
    
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User createdBy;
    
    @Column(name="created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name="updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    
    public Post()
	{
	}
    public Post(Long id)
	{
    	this.id = id;
	}
    
	public Post(Long id, Long topicId, String title, String content, Long userId)
	{
		this.id = id;
		this.topic = new Topic(topicId);
		this.title = title;
		this.content = content;
		this.createdBy = new User(userId);
	}
	public Post(Long id, String title, String content, Long userId)
	{
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdBy = new User(userId);
	}
	public Post(Long id, Topic topic, String title, String content, User createdBy)
	{
		this.id = id;
		this.topic = topic;
		this.title = title;
		this.content = content;
		this.createdBy = createdBy;
	}
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public Topic getTopic()
	{
		return topic;
	}
	public void setTopic(Topic topic)
	{
		this.topic = topic;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public User getCreatedBy()
	{
		return createdBy;
	}
	public void setCreatedBy(User createdBy)
	{
		this.createdBy = createdBy;
	}
	public Date getCreatedOn()
	{
		return createdOn;
	}
	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn()
	{
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn)
	{
		this.updatedOn = updatedOn;
	}
    
    
    
}
