/**
 * 
 */
package com.sivalabs.blogosphere.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skatam
 *
 */
public class Tag 
{
	private Integer tagId;
	private String tagName;
	private List<Post> posts = new ArrayList<Post>();
	
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
}
