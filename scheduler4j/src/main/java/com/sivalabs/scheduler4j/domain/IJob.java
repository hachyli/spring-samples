/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.scheduler4j.domain;

/**
 * @author K. Siva Prasad Reddy
 * Date : 10-Sep-2011
 */
public interface IJob
{
	public ExecutionStatus execute(JobData data);
}
