
package com.sivalabs.linkshare.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author skatam
 */
@Entity
@Table(name = "user_master")
@NamedQueries
({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "User.findByLastname", query = "SELECT u FROM User u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByDob", query = "SELECT u FROM User u WHERE u.dob = :dob")
    
})

public class User extends BaseDomainObject
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    
    @Basic(optional = false)
    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;
    
    @Column(name = "lastname", length = 50)
    private String lastname;
    
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "votedBy")
    private Collection<Vote> votes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postedBy")
    private Collection<Link> links;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postedBy")
    private Collection<Comment> comments;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_login_id")
    private UserLogon userLogon;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String firstname, String email) {
        this.userId = userId;
        this.firstname = firstname;
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public UserLogon getUserLogon() {
        return userLogon;
    }

    public void setUserLogon(UserLogon userLogon) {
        this.userLogon = userLogon;
    }

	public Collection<Vote> getVotes() {
		if(votes == null){
			votes = new ArrayList<Vote>();
		}
		return votes;
	}

	public void setVotes(Collection<Vote> votes) {
		this.votes = votes;
	}

	public Collection<Link> getLinks() {
		if(links==null){
			links = new ArrayList<Link>();
		}
		return links;
	}

	public void setLinks(Collection<Link> links) {
		this.links = links;
	}

	public Collection<Comment> getComments() {
		if(comments==null){
			comments = new ArrayList<Comment>();
		}
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

}
