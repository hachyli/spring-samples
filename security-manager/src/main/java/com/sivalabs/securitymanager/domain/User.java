/**
 * This software is developed by author of http://sivalabs.blogspot.com.
 * This is a freeware. You can use it, change it, redistribute it.
 */
package com.sivalabs.securitymanager.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author K. Siva Prasad Reddy
 * Date  : Aug 9, 2011
 *
 */
@Entity
public class User
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private Date dob;
	private boolean active;
	
	@Transient private Set<Role> roles = new HashSet<Role>();
	@Transient private Set<Privilege> additionalPrivileges = new HashSet<Privilege>();
	@Transient private Set<Privilege> revokedPrivileges = new HashSet<Privilege>();
	
	public User()
	{
	}
	
	
	public User(int userId, String username, String password, String firstname,
			String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.email = email;
	}


	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public Date getDob()
	{
		return dob;
	}
	public void setDob(Date dob)
	{
		this.dob = dob;
	}
	public boolean isActive()
	{
		return active;
	}
	public void setActive(boolean active)
	{
		this.active = active;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Set<Role> getRoles()
	{
		return roles;
	}
	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}
	public Set<Privilege> getAdditionalPrivileges()
	{
		return additionalPrivileges;
	}
	public void setAdditionalPrivileges(Set<Privilege> additionalPrivileges)
	{
		this.additionalPrivileges = additionalPrivileges;
	}
	public Set<Privilege> getRevokedPrivileges()
	{
		return revokedPrivileges;
	}
	public void setRevokedPrivileges(Set<Privilege> revokedPrivileges)
	{
		this.revokedPrivileges = revokedPrivileges;
	}
	 
}
