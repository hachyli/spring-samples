/**
 * 
 */
package com.sivalabs.core.logging;

/**
 * @author skatam
 *
 */
public class Logger
{
	private org.slf4j.Logger internalLogger = null;
	
	public static Logger getLogger(Class<?> clazz)
	{
		return new Logger(org.slf4j.LoggerFactory.getLogger(clazz));
	}
	
	public static Logger getLogger(String name)
	{
		return new Logger(org.slf4j.LoggerFactory.getLogger(name));
	}
	
	public Logger(org.slf4j.Logger internalLogger)
	{
		super();
		this.internalLogger = internalLogger;
	}
	public org.slf4j.Logger getInternalLogger()
	{
		return internalLogger;
	}
	
	/************************ INFO *******************************/
	public void info(String msg) 
	{
		this.getInternalLogger().info(msg);
	}
	
	public void info(String msg, Object... args) 
	{
		this.getInternalLogger().info(msg, args);
	}
	
	public void info(String msg, Throwable throwable) 
	{
		this.getInternalLogger().info(msg, throwable);
	}
	
	/************************ DEBUG*******************************/
	public void debug(String msg) 
	{
		this.getInternalLogger().debug(msg);
	}
	public void debug(String msg, Object... args) 
	{
		this.getInternalLogger().debug(msg, args);
	}
	
	public void debug(String msg, Throwable throwable) 
	{
		this.getInternalLogger().debug(msg, throwable);
	}
	
	/************************ WARN*******************************/
	public void warn(String msg) 
	{
		this.getInternalLogger().warn(msg);
	}
	
	public void warn(String msg, Object... args) 
	{
		this.getInternalLogger().warn(msg, args);
	}
	
	public void warn(String msg, Throwable throwable) 
	{
		this.getInternalLogger().warn(msg, throwable);
	}
	
	/************************ ERROR *******************************/
	public void error(String msg) 
	{
		this.getInternalLogger().error(msg);
	}
	
	public void error(String msg, Object... args) 
	{
		this.getInternalLogger().error(msg, args);
	}
	
	public void error(String msg, Throwable throwable) 
	{
		this.getInternalLogger().error(msg, throwable);
	}
}
