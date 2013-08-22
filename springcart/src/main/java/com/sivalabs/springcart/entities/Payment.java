/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sivalabs.springcart.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Siva
 */
@Entity
@Table(name = "payments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findById", query = "SELECT p FROM Payment p WHERE p.id = :id"),
    @NamedQuery(name = "Payment.findByCreatedOn", query = "SELECT p FROM Payment p WHERE p.createdOn = :createdOn"),
    @NamedQuery(name = "Payment.findByUpdatedOn", query = "SELECT p FROM Payment p WHERE p.updatedOn = :updatedOn"),
    @NamedQuery(name = "Payment.findByCreditCardNumber", query = "SELECT p FROM Payment p WHERE p.creditCardNumber = :creditCardNumber"),
    @NamedQuery(name = "Payment.findByCvv", query = "SELECT p FROM Payment p WHERE p.cvv = :cvv"),
    @NamedQuery(name = "Payment.findByExpiryDate", query = "SELECT p FROM Payment p WHERE p.expiryDate = :expiryDate")})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @Size(max = 255)
    @Column(name = "creditCardNumber")
    private String creditCardNumber;
    @Size(max = 255)
    @Column(name = "cvv")
    private String cvv;
    @Column(name = "expiryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentId")
    private Set<CustomerOrder> customerOrderSet;

    public Payment() {
    }

    public Payment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @XmlTransient
    public Set<CustomerOrder> getCustomerOrderSet() {
        return customerOrderSet;
    }

    public void setCustomerOrderSet(Set<CustomerOrder> customerOrderSet) {
        this.customerOrderSet = customerOrderSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sivalabs.bookstore.entities.Payment[ id=" + id + " ]";
    }
    
}
