/**
 * 
 */
package com.sivalabs.blogosphere.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author skatam
 *
 */
public class Post 
{
	private Integer postId;
	private String title;
	private String content;
	private Date createdOn;
	private Blog blog;
	private List<Comment> comments = null;
	private List<Tag> tags = null;
	
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public List<Comment> getComments() {
		if(comments==null){
			comments = new ArrayList<Comment>();
		}
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Tag> getTags() {
		if(tags == null){
			tags = new ArrayList<Tag>();
		}		
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	
	
}
