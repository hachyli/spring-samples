/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.scheduler4j.util;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;

import com.sivalabs.scheduler4j.domain.Job;
import com.sivalabs.scheduler4j.domain.Trigger;

/**
 * @author K. Siva Prasad Reddy
 * Date : 10-Sep-2011
 */
public class QuartzUtil
{
	private QuartzUtil()
	{
	}
	
	public static JobDetail buildJobDetail(Job job)
	{
		
		JobDetail jobDetail = JobBuilder.newJob(job.getJobImplClass())
                .withIdentity(job.getName(), job.getGroup())
                .build();
		return jobDetail;
	}
	
	public static CronTrigger buildTrigger(Trigger trigger) throws ParseException
	{
		CronTrigger cronTrigger = newTrigger()
			    .withIdentity(trigger.getName(), trigger.getGroup())
			    .withSchedule(cronSchedule(trigger.getCronExpression()))
			    .build();
		return cronTrigger;
	}
}
