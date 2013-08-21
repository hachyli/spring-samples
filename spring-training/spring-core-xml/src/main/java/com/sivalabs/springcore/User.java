/**
 * 
 */
package com.sivalabs.springcore;

/**
 * @author Siva
 *
 */
public class User 
{
	private Integer userId;
	private String userName;
	
	public User()
	{
		System.out.println("----User()--------");
	}
	public User(Integer userId, String userName)
	{
		System.out.println("----User(Integer userId, String userName)--------");
		this.userId = userId;
		this.userName = userName;
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
	
}
