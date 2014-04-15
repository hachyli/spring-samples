/**
 * 
 */
package com.sivalabs.forum.domain;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * @author skatam
 * 
 */
@Entity
@Table(name="forums")
public class Forum extends DomainObject
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="forum_id") private long forumId;
	@Column(name="forum_name") private String forumName;
	@Column(name="description")	private String description;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="forum")
	@JoinColumn(name="forum_id")
	@OrderBy("postedOn DESC")
	private Set<Topic> topics = new TreeSet<Topic>();

	@OneToOne
	@JoinColumn(name="last_topic_id")
	private Topic lastTopic;
	
	@Column(name="topics_count", nullable=false) 
	private long topicsCount = 0 ;
	
	public long getForumId()
	{
		return forumId;
	}

	public void setForumId(long forumId)
	{
		this.forumId = forumId;
	}

	public String getForumName()
	{
		return forumName;
	}

	public void setForumName(String forumName)
	{
		this.forumName = forumName;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Set<Topic> getTopics()
	{
		return topics;
	}

	public void setTopics(Set<Topic> topics)
	{
		this.topics = topics;
	}

	public long getTopicsCount()
	{
		return topicsCount;
	}

	public void setTopicsCount(long topicsCount)
	{
		this.topicsCount = topicsCount;
	}
	
	public String getLastTopicDescription()
	{
		if(this.lastTopic != null){
			
		return this.lastTopic.getTitle()+ " \n At "
				+this.lastTopic.getPostedOn()
				+" by "+this.lastTopic.getStartedBy().getFirstName();
		}
		return "";
	}

	public void incrementTopicsCount()
	{
		this.topicsCount++;
	}

	public Topic getLastTopic()
	{
		return lastTopic;
	}

	public void setLastTopic(Topic lastTopic)
	{
		this.lastTopic = lastTopic;
	}

}
