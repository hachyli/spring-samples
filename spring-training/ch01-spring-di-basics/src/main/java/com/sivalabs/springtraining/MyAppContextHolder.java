/**
 * 
 */
package com.sivalabs.springtraining;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Siva
 *
 */
public class MyAppContextHolder implements ApplicationContextAware
{
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public <T> T getBean(Class<T> type) {
		return applicationContext.getBean(type);
	}

}
