package com.sivalabs.linkshare.entities;

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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author skatam
 */
@Entity
@Table(name = "link")
@NamedQueries
	({
    @NamedQuery(name = "Link.findAll", query = "SELECT l FROM Link l"),
    @NamedQuery(name = "Link.findByLinkId", query = "SELECT l FROM Link l WHERE l.linkId = :linkId"),
    @NamedQuery(name = "Link.findByTitle", query = "SELECT l FROM Link l WHERE l.title = :title"),
    @NamedQuery(name = "Link.findByUrl", query = "SELECT l FROM Link l WHERE l.url = :url"),
    @NamedQuery(name = "Link.findByPostedOn", query = "SELECT l FROM Link l WHERE l.postedOn = :postedOn")
    })

public class Link extends BaseDomainObject
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "link_id", nullable = false)
    private Integer linkId;
    
    @Basic(optional = false)
    @Column(name = "title", nullable = false, length = 256)
    private String title;
    
    @Basic(optional = false)
    @Column(name = "url", nullable = false, length = 512)
    private String url;
    
    @Basic(optional = false)
    @Column(name = "posted_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedOn;
    
    
    @JoinColumn(name = "posted_by", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false)
    private User postedBy;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "link")
    private Collection<Vote> votes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "link")
    private Collection<Comment> comments;

    public Link() {
    }

    public Link(Integer linkId) {
        this.linkId = linkId;
    }

    public Link(Integer linkId, String title, String url, Date postedOn) {
        this.linkId = linkId;
        this.title = title;
        this.url = url;
        this.postedOn = postedOn;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }
    
    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

	public Collection<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Collection<Vote> votes) {
		this.votes = votes;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

}
