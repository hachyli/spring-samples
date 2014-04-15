/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.scheduler4j;

import com.sivalabs.scheduler4j.config.provider.JobConfigProvider;

/**
 * @author K. Siva Prasad Reddy
 * Date : 10-Sep-2011
 */
public class QuartzSchedulerFactory
{
	private QuartzSchedulerFactory()
	{
	}
	public static QuartzScheduler getQuartzScheduler(JobConfigProvider jobConfigProvider)
	{
		return new QuartzScheduler(jobConfigProvider.getJobConfiguration());
	}
}
