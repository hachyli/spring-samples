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
@Table(name = "TOPICS")
public class Topic implements Serializable
{
	private static final long serialVersionUID = 1L;
	
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "topic_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="forum_id", nullable=false)
    private Forum forum;
    @Column(nullable=false)
    private String title;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User createdBy;
    
    @Column(name="created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name="updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @OneToMany(cascade=CascadeType.ALL, mappedBy="topic")
    private Set<Post> posts = new HashSet<Post>();
    
    /*
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="last_post_id")
    private Post lastPost;
    */
    @Embedded
    private LastPost lastPost;
    
    public Topic()
   	{
   	}
    public Topic(Long id)
   	{
       	this.id = id;
   	}
    
	public Topic(Long id, String title, Long userId)
	{
		this.id = id;
		this.title = title;
		this.createdBy = new User(userId);
	}
	public Topic(Long id, Long forumId, String title, Long userId)
	{
		this.id = id;
		this.forum = new Forum(forumId);
		this.title = title;
		this.createdBy = new User(userId);
	}
	public Topic(Long id, Forum forum, String title, User createdBy)
	{
		this.id = id;
		this.forum = forum;
		this.title = title;
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
	public Forum getForum()
	{
		return forum;
	}
	public void setForum(Forum forum)
	{
		this.forum = forum;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
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
	public Set<Post> getPosts()
	{
		return posts;
	}
	public void setPosts(Set<Post> posts)
	{
		this.posts = posts;
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
