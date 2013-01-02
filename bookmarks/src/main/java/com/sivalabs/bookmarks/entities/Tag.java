package com.sivalabs.bookmarks.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author Siva
 *
 */
@Entity
@Table(name = "tags")
@XmlRootElement
public class Tag implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer tagId;
    @Column(name="tag_name",nullable=false, unique=true)
    private String tagName;
    private String description;
    
    @ManyToMany
    @JoinTable(name = "bookmark_tag",
    	joinColumns = {@JoinColumn(name="tag_id")},
    	inverseJoinColumns = {@JoinColumn(name="bookmark_id")}
    )
    private Set<BookMark> bookMarks;
    @Override
    public boolean equals(Object obj) 
    {
    	   if (obj == null) { return false; }
    	   if (obj == this) { return true; }
    	   if (obj.getClass() != getClass()) {
    	     return false;
    	   }
    	   Tag rhs = (Tag) obj;
    	   return new EqualsBuilder()
    	                // .appendSuper(super.equals(obj))
    	                 .append(tagName, rhs.tagName)
    	                 .isEquals();
    }
    
    @Override
    public int hashCode() 
    {
        // you pick a hard-coded, randomly chosen, non-zero, odd number
        // ideally different for each class
        return new HashCodeBuilder(17, 37).
          append(tagName).
          toHashCode();
    }

    public Tag()
	{
	}
	public Tag(Integer tagId)
	{
		this.tagId = tagId;
	}
	public Tag(Integer tagId, String tagName)
	{
		this.tagId = tagId;
		this.tagName = tagName;
	}
	public Tag(Integer tagId, String tagName, String description)
	{
		this.tagId = tagId;
		this.tagName = tagName;
		this.description = description;
	}
	public Integer getTagId()
	{
		return tagId;
	}
	public void setTagId(Integer tagId)
	{
		this.tagId = tagId;
	}
	public String getTagName()
	{
		return tagName;
	}
	public void setTagName(String tagName)
	{
		this.tagName = tagName;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}

	public Set<BookMark> getBookMarks()
	{
		if(bookMarks == null){
			bookMarks = new HashSet<BookMark>();
		}
		return bookMarks;
	}

	public void setBookMarks(Set<BookMark> bookMarks)
	{
		this.bookMarks = bookMarks;
	}
    
    
}
