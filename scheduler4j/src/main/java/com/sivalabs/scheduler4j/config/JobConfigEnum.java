/**
 * This software is developed by author of http://sivalabs.blogspot.com.
 * This is a freeware. You can use it, change it, redistribute it.
 */
package com.sivalabs.scheduler4j.config;

import org.quartz.Job;

import com.sivalabs.scheduler4j.jobs.HelloJob;

/**
 * @author K. Siva Prasad Reddy
 * Date  : Sep 8, 2011
 *
 */
public enum JobConfigEnum
{
	JOB1("J1","Job1","GROUP1",HelloJob.class,"TRG1","GROUP1","0/5 * * * * ?"),
	JOB2("J2","Job2","GROUP1",HelloJob.class,"TRG2","GROUP1","0/15 * * * * ?");
	
	private String jobId;
	private String jobName;
	private String jobGroupName;
	private Class<? extends Job> jobImplClass;
	private String triggerName;
	private String triggerGroupName;
	private String cronExpression;
	
	private JobConfigEnum(String jobId, String jobName, String jobGroupName,
			Class<? extends Job> jobImplClass, String triggerName,
			String triggerGroupName, String cronExpression)
	{
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobGroupName = jobGroupName;
		this.jobImplClass = jobImplClass;
		this.triggerName = triggerName;
		this.triggerGroupName = triggerGroupName;
		this.cronExpression = cronExpression;
	}

	public String getJobId()
	{
		return jobId;
	}

	public String getJobName()
	{
		return jobName;
	}

	public String getJobGroupName()
	{
		return jobGroupName;
	}

	public Class<? extends Job> getJobImplClass()
	{
		return jobImplClass;
	}

	public String getTriggerName()
	{
		return triggerName;
	}

	public String getTriggerGroupName()
	{
		return triggerGroupName;
	}

	public String getCronExpression()
	{
		return cronExpression;
	}
	
}
