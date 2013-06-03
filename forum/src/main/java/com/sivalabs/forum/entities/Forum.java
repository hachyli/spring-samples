package com.sivalabs.forum.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@Entity
@Table(name = "FORUMS")
public class Forum implements Serializable
{
	private static final long serialVersionUID = 1L;
	
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "forum_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="cat_id", nullable=false)
    private Category category;
    @Column(nullable=false)
    private String name;
    private String description;
    @Column(name="forum_order")
    private Integer order;
    @Column(name="created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name="updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="forum")
    private Set<Topic> topics = new HashSet<Topic>();
    
    /*
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="last_topic_id")
    private Topic lastTopic;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="last_post_id")
    private Post lastPost;
    */
    @Column(name="last_topic_id")
    private Long lastTopicId;
    
    @Embedded
    private LastPost lastPost;
    
    public Forum()
	{
	}
    public Forum(Long id)
	{
    	this.id = id;
	}
    
	public Forum(Long id, String name, String description, Integer order)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.order = order;
	}
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public Category getCategory()
	{
		return category;
	}
	public void setCategory(Category category)
	{
		this.category = category;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Integer getOrder()
	{
		return order;
	}
	public void setOrder(Integer order)
	{
		this.order = order;
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
	public Set<Topic> getTopics()
	{
		return topics;
	}
	public void setTopics(Set<Topic> topics)
	{
		this.topics = topics;
	}
	public Long getLastTopicId()
	{
		return lastTopicId;
	}
	public void setLastTopicId(Long lastTopicId)
	{
		this.lastTopicId = lastTopicId;
	}
	public LastPost getLastPost()
	{
		return lastPost;
	}
	public void setLastPost(LastPost lastPost)
	{
		this.lastPost = lastPost;
	}
    
}
