package com.sivalabs.springcart.web.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siva
 *
 */
public class ShoppingCart
{
	private List<LineItem> items = new ArrayList<LineItem>();
	
	public List<LineItem> getItems()
	{
		if(items == null){
			items = new ArrayList<LineItem>();
		}
		return items;
	}
	public void setItems(List<LineItem> items)
	{
		this.items = items;
	}
	public void addItem(LineItem item)
	{
		getItems().add(item);
	}
	
	public boolean hasProduct(Integer productId){
		for (LineItem item : items)
		{
			if(productId == item.getProduct().getId()){
				return true;
			}
		}
		return false;
	}
	
	public LineItem getLineItem(Integer productId){
		for (LineItem item : items)
		{
			if(productId == item.getProduct().getId()){
				return item;
			}
		}
		return null;
	}
	
	public int getProductsCount()
	{
		int count = 0;
		for (LineItem item : items)
		{
			count += item.getQuantity();
		}
		return count;
	}
}
