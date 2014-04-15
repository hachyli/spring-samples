/**
 * 
 */
package com.sivalabs.scheduler4j.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author skatam
 *
 */
public class SpringBeanProvider
{
	private static final String BEAN_DEF_CONFIG_FILENAME = "applicationContext.xml";
	private static final ApplicationContext SPRING_APP_CONTEXT = buildSpringAppContext();
	
	private static ApplicationContext buildSpringAppContext()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext(BEAN_DEF_CONFIG_FILENAME);
		return ctx;
	}
	
	public static final ApplicationContext getApplicationContext()
	{
		return SPRING_APP_CONTEXT;
	}
	
	public static final Object getBean(String id)
	{
		return SPRING_APP_CONTEXT.getBean(id);
	}
	
	public static final <T> T getBean(Class<T> clazz)
	{
		return SPRING_APP_CONTEXT.getBean(clazz);
	}
	
	public static final <T> T getBean(String id, Class<T> clazz)
	{
		return SPRING_APP_CONTEXT.getBean(id, clazz);
	}
}
