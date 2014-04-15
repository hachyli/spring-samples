/**
 * 
 */
package com.sivalabs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author skatam
 *
 */
public class TestClient
{
	private static String[] configLocations = 
	{
		"spring/spring-context-quartz.xml"
	};
	public static void main(String[] args) throws Exception
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);
		org.quartz.impl.StdScheduler scheduler = (org.quartz.impl.StdScheduler) ctx.getBean("schedulerFactoryBean");
		//Scheduler scheduler = schedulerFactoryBean.getScheduler();
		System.out.println(scheduler);
		
	}
}
