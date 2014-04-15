/**
 * 
 */
package com.sivalabs.common.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sivalabs.phonebook.Contact;

/**
 * @author K. Siva Prasad Reddy
 *
 */

@Entity
@Table(name="USERS")
public class User
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	@Column(unique=true, nullable=false) 
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	@OneToMany(mappedBy="user")
	private Set<Contact> contacts = new HashSet<Contact>();
	
	public User()
	{
	}
	public User(int userId, String username, String password, String firstname,
			String lastname)
	{
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
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
	public String getFirstname()
	{
		return firstname;
	}
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	public String getLastname()
	{
		return lastname;
	}
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	public Set<Contact> getContacts()
	{
		return contacts;
	}
	public void setContacts(Set<Contact> contacts)
	{
		this.contacts = contacts;
	}
	
	
}
