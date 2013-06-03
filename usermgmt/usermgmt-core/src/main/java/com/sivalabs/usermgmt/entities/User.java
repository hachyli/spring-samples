/**
 * 
 */
package com.sivalabs.usermgmt.entities;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Siva
 *
 */
@XmlRootElement
public class User 
{
	private Integer userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String emailId;
	private boolean disabled;
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId
				+ ", disabled=" + disabled + "]";
	}

	public User() {
	}
	
	public User(Integer userId) {
		this.userId = userId;
	}
	public User(Integer userId, String userName, String password,
			String firstName) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
	}
	public User(String userName, String password, String firstName) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
	}
	public User(Integer userId, String userName, String password,
			String firstName, String lastName, String emailId, boolean disabled) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.disabled = disabled;
	}

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
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
}
