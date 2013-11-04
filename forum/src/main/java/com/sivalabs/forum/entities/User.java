package com.sivalabs.forum.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author Siva
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false, unique=true)
    private String email;
    @Column(name="created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name="updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    
    @Column(nullable=false, unique=true)
    private String username;
    @Column(nullable=false)
    private String password;
    private boolean disabled;
    
    @OneToMany(mappedBy="user", fetch=FetchType.EAGER)
    private Set<Role> roles = new HashSet<Role>();
    
    @OneToMany(mappedBy="createdBy")
    private Set<Topic> topics = new HashSet<Topic>();
    @OneToMany(mappedBy="createdBy")
    private Set<Post> posts = new HashSet<Post>();
    
    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String name, String email, String username, String password)
	{
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	@Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
     
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public Set<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}

	public Set<Topic> getTopics()
	{
		return topics;
	}

	public void setTopics(Set<Topic> topics)
	{
		this.topics = topics;
	}

	public Set<Post> getPosts()
	{
		return posts;
	}

	public void setPosts(Set<Post> posts)
	{
		this.posts = posts;
	}

}
