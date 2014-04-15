/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.scheduler4j.config.provider;

import com.sivalabs.scheduler4j.config.JobConfig;


/**
 * @author K. Siva Prasad Reddy
 * Date : 10-Sep-2011
 */
public interface JobConfigProvider
{
	public JobConfig getJobConfiguration();
}
