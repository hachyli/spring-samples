/**
 * This software is developed by author of http://sivalabs.blogspot.com.
 * This is a freeware. You can use it, change it, redistribute it.
 */
package com.sivalabs.scheduler4j.tests;

import org.quartz.SchedulerException;

import com.sivalabs.scheduler4j.JobExecutor;
import com.sivalabs.scheduler4j.QuartzScheduler;
import com.sivalabs.scheduler4j.QuartzSchedulerFactory;
import com.sivalabs.scheduler4j.config.provider.EnumJobConfigProvider;
import com.sivalabs.scheduler4j.config.provider.JobConfigProvider;
import com.sivalabs.scheduler4j.domain.IJob;
import com.sivalabs.scheduler4j.domain.JobData;
import com.sivalabs.scheduler4j.jobs.HelloJob;

/**
 * @author K. Siva Prasad Reddy
 * Date  : Sep 7, 2011
 *
 */
public class Scheduler4jTests
{

	/**
	 * @param args
	 * @throws Exception 
	 * @throws SchedulerException 
	 */
	public static void main(String[] args) throws Exception
	{
		JobConfigProvider configProvider = new EnumJobConfigProvider();
		QuartzScheduler quartzScheduler = QuartzSchedulerFactory.getQuartzScheduler(configProvider);
		quartzScheduler.start();

		
		JobExecutor jobExecutor=new JobExecutor();
		JobData data = new JobData();
		data.put("FromExecutor", "Helloooooooooooooo");
		IJob job = new HelloJob();
		jobExecutor.executeJob(job , data);
	}

}
