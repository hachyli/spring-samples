/**
 * 
 */
package com.sivalabs.core.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.test.BaseTest;

/**
 * @author skatam
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
(locations=
	{
		//"classpath:applicationContext-test.xml",
		//"classpath:spring/spring-context-quartz.xml"
		"classpath:applicationContext.xml"
	}
)
public class SpringTest  extends BaseTest
{
	@Autowired
	private ApplicationContext applicationContext;
		
	@Test
	public void testQuartzScheduling()
	{
		//SchedulerFactoryBean schedulerFactoryBean = applicationContext.getBean(SchedulerFactoryBean.class);
		//System.out.println(schedulerFactoryBean);
		/**
		CronTriggerBean tr1 = new CronTriggerBean();
		tr1.setCronExpression("0/10 * * * * ?");
		JobDetailBean jd1 = new JobDetailBean();
		jd1.setJobClass(TestJob1.class);
		Map m1 = new HashMap();
		m1.put("var1", "Variable 1");
		jd1.setJobDataAsMap(m1);
		tr1.setJobDetail(jd1 );
		
		CronTriggerBean tr2 = new CronTriggerBean();
		tr2.setCronExpression("0/6 * * * * ?");
		JobDetailBean jd2 = new JobDetailBean();
		jd1.setJobClass(TestJob2.class);
		Map m2 = new HashMap();
		m2.put("var2", "Variable 2");
		jd2.setJobDataAsMap(m2);
		tr2.setJobDetail(jd2 );
		
		CronTriggerBean[] triggers = new CronTriggerBean[]{tr1,tr2};
		schedulerFactoryBean.setTriggers(triggers);*/
		
	}
}
