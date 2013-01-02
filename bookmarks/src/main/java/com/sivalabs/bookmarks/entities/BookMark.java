/**
 * 
 */
package com.sivalabs.bookmarks.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringUtils;

/**
 * @author Siva
 *
 */
@Entity
@Table(name = "bookmarks")
@XmlRootElement
public class BookMark implements Serializable 
{
     private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "bookmark_id")
     private Integer bookmarkId;
     @Column(nullable=false)
     private String title;
     @Column(nullable=false)
     private String url;
     private String description;
     @ManyToOne
     @JoinColumn(name="user_id")
     private User user;
	
     @ManyToMany(cascade=CascadeType.ALL)
     @JoinTable(name = "bookmark_tag",
     	joinColumns = {@JoinColumn(name="bookmark_id")},
     	inverseJoinColumns = {@JoinColumn(name="tag_id")}
     )
     private Set<Tag> tags;
     
     public BookMark() {
     }
     
     public BookMark(Integer bookmarkId) {
		super();
		this.bookmarkId = bookmarkId;
	}
     public BookMark(Integer bookmarkId, String title, String url,
 			String description) {
 		super();
 		this.bookmarkId = bookmarkId;
 		this.title = title;
 		this.url = url;
 		this.description = description;
 	}
     public BookMark(Integer bookmarkId, String title, String url) {
  		super();
  		this.bookmarkId = bookmarkId;
  		this.title = title;
  		this.url = url;
  	}
     public BookMark(Integer bookmarkId, String title, String url,
 			String description, User user) {
 		super();
 		this.bookmarkId = bookmarkId;
 		this.title = title;
 		this.url = url;
 		this.description = description;
 		this.user = user;
 	}
	public Integer getBookmarkId() {
		return bookmarkId;
	}
	public void setBookmarkId(Integer bookmarkId) {
		this.bookmarkId = bookmarkId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Set<Tag> getTags()
	{
		if(tags == null){
			tags = new HashSet<Tag>();
		}
		return tags;
	}

	public void setTags(Set<Tag> tags)
	{
		this.tags = tags;
	}
	
	public String getFormattedTags()
	{
		StringBuilder sb = new StringBuilder();
		for (Tag tag : tags)
		{
			sb.append(tag.getTagName()+",");
		}
		String str = sb.toString();
		/*if(str.length()>0){
			str = str.substring(0,str.length()-1); 
		}*/
		str = StringUtils.chomp(str, ",");
		return str;
	}
     
}
