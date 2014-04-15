/**
 * This software is developed by author of http://sivalabs.blogspot.com.
 * This is a freeware. You can use it, change it, redistribute it.
 */
package com.sivalabs.scheduler4j.domain;

/**
 * @author K. Siva Prasad Reddy
 * Date  : Sep 8, 2011
 *
 */
public class Trigger
{
	private String name;
	private String group;
	private String cronExpression;
	
	public static Trigger build(String name, String group, String cronExpression)
	{
		return new Trigger(name, group, cronExpression);
	}
	private Trigger(String name, String group, String cronExpression)
	{
		super();
		this.name = name;
		this.group = group;
		this.cronExpression = cronExpression;
	}
	public String getName()
	{
		return name;
	}
	public String getGroup()
	{
		return group;
	}
	public String getCronExpression()
	{
		return cronExpression;
	}
	
}
