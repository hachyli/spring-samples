/**
 * 
 */
package com.sivalabs.blogger.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Siva
 * 
 */
public class User extends BaseEntity
{

	private int id;
	private String userName;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private Date dob;
	private List<Blog> blogs = new ArrayList<>();

	public User()
	{
	}

	public User(int id)
	{
		this.id = id;
	}

	public User(int id, String userName, String password, String email, String firstName, String lastName, Date dob)
	{
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + "]";
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
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

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Date getDob()
	{
		return dob;
	}

	public void setDob(Date dob)
	{
		this.dob = dob;
	}

	public List<Blog> getBlogs()
	{
		return blogs;
	}

	public void setBlogs(List<Blog> blogs)
	{
		this.blogs = blogs;
	}

}
