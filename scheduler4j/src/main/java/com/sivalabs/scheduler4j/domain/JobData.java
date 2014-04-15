/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.scheduler4j.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author K. Siva Prasad Reddy
 * Date : 10-Sep-2011
 */
public class JobData
{
	private Map<String, Object> data = new HashMap<String, Object>();
	
	public void put(String key, Object value)
	{
		this.data.put(key, value);
	}
	public Object get(String key)
	{
		return this.data.get(key);
	}
	public Map<String, Object> getAll()
	{
		return this.data;
	}
	public void putAll(Map<String, Object> map)
	{
		this.data.putAll(map);
	}
	public void putAll(JobData additionalJobData)
	{
		if(additionalJobData != null)
		{
			this.data.putAll(additionalJobData.getAll());
		}
	}
}
