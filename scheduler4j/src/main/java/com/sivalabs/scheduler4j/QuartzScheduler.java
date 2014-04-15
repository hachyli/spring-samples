/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.scheduler4j;

import java.text.ParseException;
import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import com.sivalabs.scheduler4j.config.JobConfig;
import com.sivalabs.scheduler4j.domain.Job;
import com.sivalabs.scheduler4j.util.QuartzUtil;


/**
 * @author K. Siva Prasad Reddy
 * Date : 10-Sep-2011
 */
public class QuartzScheduler
{
	private JobConfig jobConfig;
	private Scheduler scheduler;
	private boolean started = false;
	
	public QuartzScheduler(JobConfig jobConfig)
	{
		super();
		this.jobConfig = jobConfig;
	}

	public void start() throws Exception
	{
		if(!started)
		{
			this.init();
			this.scheduleJobs();
			scheduler.start();
			System.out.println("scheduler started.....");
			started = true;
		}
	}
	
	private void init() throws SchedulerException
	{
		SchedulerFactory sf = new StdSchedulerFactory();
		scheduler = sf.getScheduler();
	}
	
	private void scheduleJobs() throws ParseException, SchedulerException
	{
		List<Job> jobs = jobConfig.getJobs();
		
		for (Job job : jobs)
		{
			JobDetail jobDetail = QuartzUtil.buildJobDetail(job);
	        CronTrigger trigger = QuartzUtil.buildTrigger(job.getTrigger());
	        
	        scheduler.scheduleJob(jobDetail, trigger);
	        System.out.println("scheduled "+job.getName());
		}
	}
	
	public void stop() throws SchedulerException
	{
		scheduler.shutdown(true);
	}
	
	public JobConfig getJobMetadata()
	{
		return jobConfig;
	}
}
