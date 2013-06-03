/**
 * 
 */
package com.sivalabs.forum.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Siva
 * 
 */
@Entity
@Table(name = "CATEGORIES")
public class Category implements Serializable
{
	private static final long serialVersionUID = 1L;
	
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cat_id")
    private Long id;
    @Column(nullable=false)
    private String name;
    private String description;
    @Column(name="cat_order")
    private Integer order;
    @Column(name="created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name="updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @OneToMany(cascade=CascadeType.ALL, mappedBy="category")
    private Set<Forum> forums = new HashSet<Forum>();
    
    public Category()
	{
	}
    public Category(Long id)
	{
    	this.id = id;
	}
    
	public Category(Long id, String name, String description, Integer order)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.order = order;
	}
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Integer getOrder()
	{
		return order;
	}
	public void setOrder(Integer order)
	{
		this.order = order;
	}
	public Date getCreatedOn()
	{
		return createdOn;
	}
	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn()
	{
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn)
	{
		this.updatedOn = updatedOn;
	}
	public Set<Forum> getForums()
	{
		return forums;
	}
	public void setForums(Set<Forum> forums)
	{
		this.forums = forums;
	}
    
}
