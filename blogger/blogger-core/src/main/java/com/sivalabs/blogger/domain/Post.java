package com.sivalabs.blogger.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siva
 * 
 */
public class Post extends BaseEntity
{
	private int id;
	private String title;
	private String message;
	private int blogId;
	private User postedBy;
	private List<Comment> comments = new ArrayList<>();

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

	public int getBlogId()
	{
		return blogId;
	}

	public void setBlogId(int blogId)
	{
		this.blogId = blogId;
	}

	public User getPostedBy()
	{
		return postedBy;
	}

	public void setPostedBy(User postedBy)
	{
		this.postedBy = postedBy;
	}

	public List<Comment> getComments()
	{
		return comments;
	}

	public void setComments(List<Comment> comments)
	{
		this.comments = comments;
	}

}
