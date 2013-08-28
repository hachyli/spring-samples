/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sivalabs.springcart.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "categories")
@XmlRootElement
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;    
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    
    @OneToMany(mappedBy = "category")
    private Set<Product> products;
    
    /*public Category getCopy()
    {
    	Category category = new Category();
    	category.setId(id);
    	category.setName(name);
    	category.setDescription(description);
    	category.setCreatedOn(createdOn);
    	category.setUpdatedOn(updatedOn);
    	if(products != null)
    	{
    		for (Product product : products) 
    		{
    			category.addProduct(product.getCopy());
			}
    	}
    	
    	return category;
    }
    */
	public Category() {
    }

    public Category(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //@XmlTransient
    public Set<Product> getProducts() {
    	if(products == null){
    		products = new HashSet<Product>();
    	}
        return products;
    }
    /*public List<Product> getProductsList() {
        return new ArrayList<Product>(products);
    }*/
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    public void addProduct(Product product) {
    	getProducts().add(product);
	}

    
}
