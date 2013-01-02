
package com.sivalabs.bookmarks.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Siva
 */
@Entity
@Table(name = "users")
@XmlRootElement
public class User implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    
    @NotNull
    @Column(name = "username", nullable=false)
    private String userName;
    
    @NotNull
    @Column(name = "password", nullable=false)
    private String password;
    
    @Column(name = "email", nullable=false)
    private String email;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="user")
    private Set<BookMark> bookMarks = new HashSet<BookMark>();

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String userName, String password, String email) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
    public User(Integer userId, String userName, String password, String email,
			Set<BookMark> bookMarks) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.bookMarks = bookMarks;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<BookMark> getBookMarks() {
		return bookMarks;
	}

	public void setBookMarks(Set<BookMark> bookMarks) {
		this.bookMarks = bookMarks;
	}

}
