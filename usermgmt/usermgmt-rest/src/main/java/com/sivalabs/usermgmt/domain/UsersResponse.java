package com.sivalabs.usermgmt.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.sivalabs.usermgmt.entities.User;

/**
 * @author Siva
 *
 */
@XmlRootElement
public class UsersResponse
{
	private List<User> users;
	public UsersResponse()
	{
	}
	public UsersResponse(List<User> users)
	{
		this.users = users;
	}
	public void setUsers(List<User> users)
	{
		this.users = users;
	}
	public List<User> getUsers()
	{
		return users;
	}
}
