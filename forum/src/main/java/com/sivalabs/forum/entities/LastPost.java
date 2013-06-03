package com.sivalabs.forum.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@Embeddable
public class LastPost
{
	@Column(name="last_post_id")
	private Long lastPostId;
	@Column(name="last_post_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPostDate;
	
	@Column(name="last_post_user_id")
    private Long lastPostUserId;
	@Column(name="last_post_username")
	private String lastPostUserName;
	
	public Long getLastPostId()
	{
		return lastPostId;
	}
	public void setLastPostId(Long lastPostId)
	{
		this.lastPostId = lastPostId;
	}
	public Date getLastPostDate()
	{
		return lastPostDate;
	}
	public void setLastPostDate(Date lastPostDate)
	{
		this.lastPostDate = lastPostDate;
	}
	
	public Long getLastPostUserId()
	{
		return lastPostUserId;
	}
	public void setLastPostUserId(Long lastPostUserId)
	{
		this.lastPostUserId = lastPostUserId;
	}
	public String getLastPostUserName()
	{
		return lastPostUserName;
	}
	public void setLastPostUserName(String lastPostUserName)
	{
		this.lastPostUserName = lastPostUserName;
	}
	
}
