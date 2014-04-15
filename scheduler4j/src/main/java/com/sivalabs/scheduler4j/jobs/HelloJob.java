/* 
 * Copyright 2005 - 2009 Terracotta, Inc. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */

package com.sivalabs.scheduler4j.jobs;

import java.util.Date;
import java.util.Map;

import org.quartz.JobExecutionContext;

import com.sivalabs.scheduler4j.domain.AbstractJob;
import com.sivalabs.scheduler4j.domain.ExecutionStatus;
import com.sivalabs.scheduler4j.domain.JobData;

public class HelloJob extends AbstractJob
{  
    
    public HelloJob() {
    }
   
	@Override
	public ExecutionStatus execute(JobData data)
	{
		JobExecutionContext context = (JobExecutionContext) data.get("JobExecutionContext");
		if(context != null)
		{
			System.out.println("Running the Job '"+context.getJobDetail().getKey().getName()+"' at "+new Date());
		}
		Map<String, Object> map = data.getAll();
		System.out.println(map);
		return new ExecutionStatus();
	}
	
	@Override
	public JobData getAdditionalJobData()
	{
		JobData data = new JobData();
		data.put("MyName", "Siva");
		data.put("Company", "SivaLabs");
		
		return data;
	}

}
