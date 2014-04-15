
package com.sivalabs.linkshare.entities;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author skatam
 */
@Entity
@Table(name = "user_logon", 
	uniqueConstraints = {
			@UniqueConstraint(columnNames = {"username"})
    					}
	)
@NamedQueries
({
    @NamedQuery(name = "UserLogon.findAll", query = "SELECT u FROM UserLogon u"),
    @NamedQuery(name = "UserLogon.findByUserLoginId", query = "SELECT u FROM UserLogon u WHERE u.userLoginId = :userLoginId"),
    @NamedQuery(name = "UserLogon.findByUsername", query = "SELECT u FROM UserLogon u WHERE u.username = :username"),
    @NamedQuery(name = "UserLogon.findByPassword", query = "SELECT u FROM UserLogon u WHERE u.password = :password"),
    @NamedQuery(name = "UserLogon.findByActive", query = "SELECT u FROM UserLogon u WHERE u.active = :active")
})

public class UserLogon extends BaseDomainObject
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "user_login_id", nullable = false)
    private Integer userLoginId;
    
    @Basic(optional = false)
    @Column(name = "username", nullable = false, length = 20)
    private String username;
    
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    
    @Column(name = "active")
    private Boolean active;
    
   
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userLogon")
    private User user;

    public UserLogon() {
    }

    public UserLogon(Integer userLoginId) {
        this.userLoginId = userLoginId;
    }

    public UserLogon(Integer userLoginId, String username, String password) {
        this.userLoginId = userLoginId;
        this.username = username;
        this.password = password;
    }

    public Integer getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(Integer userLoginId) {
		this.userLoginId = userLoginId;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
