/**
 * 
 */
package com.sivalabs.phonebook.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author siva
 *
 */ 
public class ChangePwd 
{ 
	@NotNull(message="Password should not be null")
	@Size(min=5, max=25, message="Password should be 5 to 25 chars")
	private String pwd;
	@NotNull(message="New Password should not be null")
	@Size(min=5, max=25, message="New Password should be 5 to 25 chars")
	private String newPwd;
	@NotNull(message="Retype-Password should not be null")
	@Size(min=5, max=25, message="Retype-Password should be 5 to 25 chars")
	private String retypePwd;
	
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getRetypePwd() {
		return retypePwd;
	}
	public void setRetypePwd(String retypePwd) {
		this.retypePwd = retypePwd;
	}
	
	
}
