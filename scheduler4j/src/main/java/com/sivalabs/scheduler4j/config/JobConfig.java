/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.scheduler4j.config;

import java.util.ArrayList;
import java.util.List;

import com.sivalabs.scheduler4j.domain.Job;

/**
 * @author K. Siva Prasad Reddy
 * Date : 10-Sep-2011
 */
public class JobConfig
{
	private List<Job> jobs = new ArrayList<Job>();

	public List<Job> getJobs()
	{
		return jobs;
	}

	public void setJobs(List<Job> jobs)
	{
		this.jobs = jobs;
	}
	
}
