package com.sivalabs.jbb.web.rest.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Siva
 * 
 */
@Aspect
@Component
public class HibernateUnproxyAspect
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private Mapper dozerMapper;
	
	@Around("execution(* com.sivalabs.jbb.web.rest.*.*(..))")
	public Object unproxyHibernateEntities(ProceedingJoinPoint joinPoint) throws Throwable
	{
		Object unproxyResult = null;

		logger.info("Unproxying Hibernate Entities");

		Object result = joinPoint.proceed();
		
		try
		{
			unproxyResult = dozerMapper.map(result, result.getClass());
		} catch (Exception e)
		{
			logger.error("Some error occured while Unproxying Hibernate Entities.");
			logger.error("Returning the Hibernate Proxy itself");
			logger.error("",e);
			unproxyResult = result;
		}
		return unproxyResult ;


	}
}
