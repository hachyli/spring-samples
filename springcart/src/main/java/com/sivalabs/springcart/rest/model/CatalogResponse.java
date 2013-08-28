/**
 * 
 */
package com.sivalabs.springcart.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.sivalabs.springcart.entities.Category;


/**
 * @author Siva
 *
 */
@XmlRootElement
public class CatalogResponse {

	private List<Category> categories;
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public List<Category> getCategories() {
		return categories;
	}
}
