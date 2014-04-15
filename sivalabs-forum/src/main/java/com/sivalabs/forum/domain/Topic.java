/**
 * 
 */
package com.sivalabs.forum.domain;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author skatam
 * 
 */
@Entity
@Table(name="topics")
public class Topic extends DomainObject
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="topic_id") private long topicId;
	@Column(name="title")private String title;
	
	
	@OneToOne()
	@JoinColumn(name="started_by")
	private User startedBy;
	
	@Column(name="posted_on")private Date postedOn;
	
	@Column(name="replies_count", nullable=false)
	private long repliesCount = 0;
	
	@OneToOne()
	@JoinColumn(name="last_post_id")
	private Post lastPost;
	
	@Transient private String message;
	
	public long getRepliesCount()
	{
		return repliesCount;
	}

	public void setRepliesCount(long repliesCount)
	{
		this.repliesCount = repliesCount;
	}
	
	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	@ManyToOne
	@JoinColumn(name="forum_id")
	private Forum forum;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="topic")
	@JoinColumn(name="topic_id")
	@OrderBy("postedOn ASC")
	private Set<Post> posts = new TreeSet<Post>();

	public long getTopicId()
	{
		return topicId;
	}

	public void setTopicId(long topicId)
	{
		this.topicId = topicId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public User getStartedBy()
	{
		return startedBy;
	}

	public void setStartedBy(User startedBy)
	{
		this.startedBy = startedBy;
	}

	public Date getPostedOn()
	{
		return postedOn;
	}

	public void setPostedOn(Date postedOn)
	{
		this.postedOn = postedOn;
	}

	public Set<Post> getPosts()
	{
		return posts;
	}

	public void setPosts(Set<Post> posts)
	{
		this.posts = posts;
	}
/*
	public long getForumId()
	{
		return forumId;
	}

	public void setForumId(long forumId)
	{
		this.forumId = forumId;
	}
*/

	public Forum getForum()
	{
		return forum;
	}

	public void setForum(Forum forum)
	{
		this.forum = forum;
	}

	public void incrementRepliesCount()
	{
		this.repliesCount++;
	}

	public Post getLastPost()
	{
		return lastPost;
	}

	public void setLastPost(Post lastPost)
	{
		this.lastPost = lastPost;
	}
	
	public String getLastPostDescription()
	{
		if(this.lastPost == null){
			return "";
		}
		return this.lastPost.getPostedOn()+" by "+this.lastPost.getPostedBy().getFirstName();
	}
}
