/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.scheduler4j.config.provider;

import java.util.ArrayList;
import java.util.List;

import com.sivalabs.scheduler4j.config.JobConfig;
import com.sivalabs.scheduler4j.config.JobConfigEnum;
import com.sivalabs.scheduler4j.domain.Job;
import com.sivalabs.scheduler4j.domain.Trigger;

/**
 * @author K. Siva Prasad Reddy
 * Date : 10-Sep-2011
 */
public class EnumJobConfigProvider implements JobConfigProvider
{
	
	@Override
	public JobConfig getJobConfiguration()
	{
		JobConfig jobConfig = new JobConfig();
		List<Job> jobs = loadJobsFromJobConfigEnum();
		jobConfig.setJobs(jobs);
		return jobConfig;
	}
	
	private List<Job> loadJobsFromJobConfigEnum()
	{
		List<Job> jobs = new ArrayList<Job>();
		JobConfigEnum[] jobMetadatas = JobConfigEnum.values();
		for (JobConfigEnum jobMetadata : jobMetadatas)
		{
			Job job = Job.build(jobMetadata.getJobId(), 
					jobMetadata.getJobName(), 
					jobMetadata.getJobGroupName(), 
					jobMetadata.getJobImplClass(), 
					Trigger.build(jobMetadata.getTriggerName(),
									jobMetadata.getTriggerGroupName(),
									jobMetadata.getCronExpression()));
			jobs.add(job);
			
		}
		return jobs;
	}
}
