/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.scheduler4j.config.provider;

import java.util.ArrayList;
import java.util.List;

import com.sivalabs.scheduler4j.config.JobConfig;
import com.sivalabs.scheduler4j.domain.Job;

/**
 * @author K. Siva Prasad Reddy
 * Date : 10-Sep-2011
 */
public class JdbcJobConfigProvider implements JobConfigProvider
{

	@Override
	public JobConfig getJobConfiguration()
	{
		JobConfig jobConfig = new JobConfig();
		List<Job> jobs = loadJobsFromDatabase();
		jobConfig.setJobs(jobs);
		return jobConfig;
	}

	private List<Job> loadJobsFromDatabase()
	{
		List<Job> jobs = new ArrayList<Job>();
		
		return jobs;
	}
}
