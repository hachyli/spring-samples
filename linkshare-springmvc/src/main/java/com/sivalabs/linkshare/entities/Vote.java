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
@Table(name = "vote")
@NamedQueries
({
    @NamedQuery(name = "Vote.findAll", query = "SELECT v FROM Vote v"),
    @NamedQuery(name = "Vote.findByVoteId", query = "SELECT v FROM Vote v WHERE v.voteId = :voteId"),
    @NamedQuery(name = "Vote.findByUpDown", query = "SELECT v FROM Vote v WHERE v.upDown = :upDown"),
    @NamedQuery(name = "Vote.findByVotedOn", query = "SELECT v FROM Vote v WHERE v.votedOn = :votedOn")
})

public class Vote extends BaseDomainObject
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vote_id", nullable = false)
    private Integer voteId;
    
    @Basic(optional = false)
    @Column(name = "up_down", nullable = false)
    private boolean upDown;
    
    @Basic(optional = false)
    @Column(name = "voted_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date votedOn;
    
    @JoinColumn(name = "voted_by", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false)
    private User votedBy;
    
    @JoinColumn(name = "link_id", referencedColumnName = "link_id", nullable = false)
    @ManyToOne(optional = false)
    private Link link;

    public Vote() {
    }

    public Vote(Integer voteId) {
        this.voteId = voteId;
    }

    public Vote(Integer voteId, boolean upDown, Date votedOn) {
        this.voteId = voteId;
        this.upDown = upDown;
        this.votedOn = votedOn;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public boolean getUpDown() {
        return upDown;
    }

    public void setUpDown(boolean upDown) {
        this.upDown = upDown;
    }

    public Date getVotedOn() {
        return votedOn;
    }

    public void setVotedOn(Date votedOn) {
        this.votedOn = votedOn;
    }

    public User getVotedBy() {
        return votedBy;
    }

    public void setVotedBy(User votedBy) {
        this.votedBy = votedBy;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

}
