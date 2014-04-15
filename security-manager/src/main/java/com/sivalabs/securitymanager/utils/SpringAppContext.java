/**
 * 
 */
package com.sivalabs.securitymanager.utils;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author skatam
 *
 */
public class SpringAppContext
{
	private static Logger logger = Logger.getLogger(SpringAppContext.class);
	private static ApplicationContext APP_CONTEXT = null;
	private SpringAppContext() {}
	
	static
	{
		init();
	}
	
	private final static void init()
	{
		logger.debug("********** SpringAppContext.init() ***********");
		String[] configLocations = {"spring/applicationContext.xml"};
		APP_CONTEXT = new ClassPathXmlApplicationContext(configLocations);
		logger.debug("**************************************************************");
		
	}
	
	public static Object getBean(String beanId)
	{
		return APP_CONTEXT.getBean(beanId);
	}
	
	public static <T> T getBean(String beanId, Class<T> clazz)
	{
		return APP_CONTEXT.getBean(beanId, clazz);
	}
}
