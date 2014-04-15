
package com.sivalabs.linkshare.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author skatam
 */
@Entity
@Table(name = "comment")
@NamedQueries
({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByCommentId", query = "SELECT c FROM Comment c WHERE c.commentId = :commentId"),
    @NamedQuery(name = "Comment.findByPostedOn", query = "SELECT c FROM Comment c WHERE c.postedOn = :postedOn")
    
})
public class Comment extends BaseDomainObject
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comment_id", nullable = false)
    private Integer commentId;
    
    @Basic(optional = false)
    @Column(name = "message", nullable = false, length = 1024)
    private String message;
    
    @Basic(optional = false)
    @Column(name = "posted_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedOn;
    
    @JoinColumn(name = "link_id", referencedColumnName = "link_id", nullable = false)
    @ManyToOne(optional = false)
    private Link link;
    
    @JoinColumn(name = "posted_by", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false)
    private User postedBy;

    public Comment() {
    }

    public Comment(Integer commentId) {
        this.commentId = commentId;
    }

    public Comment(Integer commentId, String message, Date postedOn) {
        this.commentId = commentId;
        this.message = message;
        this.postedOn = postedOn;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

}
