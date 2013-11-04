/**
 * 
 */
package com.sivalabs.springcart.utils;

import java.util.List;

import com.sivalabs.springcart.entities.Category;
import com.sivalabs.springcart.entities.Product;

/**
 * @author Siva
 *
 */
public class BeanCopyUtils 
{
    public static Category getCopy(Category c)
    {
    	if(c == null) return null;
    	
    	Category category = new Category();
    	category.setId(c.getId());
    	category.setName(c.getName());
    	category.setDescription(c.getDescription());
    	category.setCreatedOn(c.getCreatedOn());
    	category.setUpdatedOn(c.getUpdatedOn());
    	List<Product> products = c.getProducts();
    	if(products != null)
    	{
    		for (Product product : products) 
    		{
    			category.addProduct(getCopy(product));
			}
    	}
    	
    	return category;
    }
    
    public static Product getCopy(Product p) {
    	
    	if(p == null) return null;
    	
		Product product = new Product();
		product.setId(p.getId());
		product.setName(p.getName());
		product.setPrice(p.getPrice());
		product.setDescription(p.getDescription());
		product.setImageUrl(p.getImageUrl());
		product.setCreatedOn(p.getCreatedOn());
		product.setUpdatedOn(p.getUpdatedOn());
		//product.setCategory(p.getCategory());
		
		return product;
	}
}
