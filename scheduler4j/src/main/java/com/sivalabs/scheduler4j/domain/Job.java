/**
 * This software is developed by author of http://sivalabs.blogspot.com.
 * This is a freeware. You can use it, change it, redistribute it.
 */
package com.sivalabs.scheduler4j.domain;

/**
 * @author K. Siva Prasad Reddy
 * Date  : Sep 7, 2011
 *
 */
public class Job
{
	private String id;
	private String name;
	private String group;
	private Class<? extends org.quartz.Job> jobImplClass;
	private Trigger trigger;
	
	public static Job build(String id, String name, String group,
			Class<? extends org.quartz.Job> jobImplClass, Trigger trigger)
	{
		return new Job(id, name, group, jobImplClass, trigger);
	}
	private Job(String id, String name, String group,
			Class<? extends org.quartz.Job> jobImplClass, Trigger trigger)
	{
		super();
		this.id = id;
		this.name = name;
		this.group = group;
		this.jobImplClass = jobImplClass;
		this.trigger = trigger;
	}

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getGroup()
	{
		return group;
	}

	public Class<? extends org.quartz.Job> getJobImplClass()
	{
		return jobImplClass;
	}

	public Trigger getTrigger()
	{
		return trigger;
	}
	
	
}
