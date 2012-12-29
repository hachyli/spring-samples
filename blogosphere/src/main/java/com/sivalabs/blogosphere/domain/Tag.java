/**
 * 
 */
package com.sivalabs.blogosphere.domain;


/**
 * @author skatam
 *
 */
public class Tag 
{
	private Integer tagId;
	private String tagName;
	private String description;
	
	public Tag() {
	}
	
	public Tag(Integer tagId) {
		this.tagId = tagId;
	}
	public Tag(Integer tagId, String tagName) {
		this.tagId = tagId;
		this.tagName = tagName;
	}
	public Tag(Integer tagId, String tagName, String description) {
		this.tagId = tagId;
		this.tagName = tagName;
		this.description = description;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
