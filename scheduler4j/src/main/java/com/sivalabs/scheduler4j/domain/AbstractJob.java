/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.scheduler4j.domain;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author K. Siva Prasad Reddy
 * Date : 10-Sep-2011
 */
public abstract class AbstractJob implements Job, IJob
{
	@Override
	public void execute(JobExecutionContext executionContext) throws JobExecutionException
	{
		JobData data = new JobData();
		data.put("JobExecutionContext", executionContext);
		JobData additionalJobData = getAdditionalJobData();
		if(additionalJobData != null){
			data.putAll(additionalJobData);
		}
		this.execute(data);
	}
	
	public JobData getAdditionalJobData()
	{
		return new JobData();
	}

}
