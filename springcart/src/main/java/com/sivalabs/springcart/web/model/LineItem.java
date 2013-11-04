package com.sivalabs.springcart.web.model;

import java.io.Serializable;

import com.sivalabs.springcart.entities.Product;


/**
 * @author Siva
 *
 */
public class LineItem implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Product product;
	private int quantity;
	public LineItem()
	{
	}
	
	public LineItem(Product product, int quantity)
	{
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct()
	{
		return product;
	}
	public void setProduct(Product product)
	{
		this.product = product;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	
}
