/**
 * 
 */
package com.sivalabs.buzz.entities;

import java.util.Date;

/**
 * @author Siva
 *
 */
public class Post {
	private Integer id;
	private String text;
	private User createdBy;
	private Date createdOn = new Date();
	
	public Post() {
		
	}
	
	public Post(Integer id, String text, Integer userId, Date createdOn) 
	{
		this.id = id;
		this.text = text;
		this.createdBy = new User(userId);
		this.createdOn = createdOn==null?new Date():createdOn;
	}
	
	public Post(Integer id, String text, User createdBy, Date createdOn) 
	{
		this.id = id;
		this.text = text;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", text=" + text + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + "]";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
}
