package com.sivalabs.blogger.domain;

/**
 * @author Siva
 * 
 */
public class Comment extends BaseEntity
{
	private int id;
	private String title;
	private String message;
	private int postId;
	private User postedBy;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
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

	public int getPostId()
	{
		return postId;
	}

	public void setPostId(int postId)
	{
		this.postId = postId;
	}

	public User getPostedBy()
	{
		return postedBy;
	}

	public void setPostedBy(User postedBy)
	{
		this.postedBy = postedBy;
	}

}
