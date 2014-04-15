/**
 * 
 */
package com.sivalabs.phonebook.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author siva
 * 
 */
@Entity
public class User 
{ 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	@NotNull(message="UserName should not be null")
	@Size(min=4, max=25, message="UserName should be 4 to 25 chars")
	private String userName;
	@NotNull(message="Password should not be null")
	@Size(min=4, max=25, message="Password should be 4 to 25 chars")
	private String password;
	@NotNull(message="FirstName should not be null")
	@Size(min=4, max=25, message="FirstName should be 4 to 25 chars")
	private String firstName;
	private String lastName;
	private String emailId;
	private Date dob;
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER, mappedBy="user")
	private List<Contact> contacts = new ArrayList<Contact>();
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public String getFullName()
	{
		return firstName+" "+lastName;
	}
}
