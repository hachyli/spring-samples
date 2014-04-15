/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.scheduler4j;

import com.sivalabs.scheduler4j.domain.ExecutionStatus;
import com.sivalabs.scheduler4j.domain.IJob;
import com.sivalabs.scheduler4j.domain.JobData;

/**
 * @author K. Siva Prasad Reddy
 * Date : 10-Sep-2011
 */
public class JobExecutor
{
	public ExecutionStatus executeJob(IJob job, JobData data)
	{
		return job.execute(data);
	}
}
