/**
 * 
 */
package com.sivalabs.buzz.entities;

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
 * @author Siva
 *
 */
@Entity
@Table
public class Post 
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="post_id")
	private Integer id;
	private String text;
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn = new Date();
	
	public Post() {
		
	}
	public Post(Integer id) 
	{
		this.id = id;
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
