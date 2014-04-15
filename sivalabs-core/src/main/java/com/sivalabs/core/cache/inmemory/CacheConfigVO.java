/**
 * 
 */
package com.sivalabs.core.cache.inmemory;

/**
 * @author Siva
 *
 */
public class CacheConfigVO
{
	private String cacheId;
	private String description;
	private String cacheLoaderClassName;
	private long refreshInterval;//in millis
	private boolean preload;
	
	public CacheConfigVO(String cacheId, String description,
			String cacheLoaderClassName, long refreshInterval, boolean preload)
	{
		super();
		this.cacheId = cacheId;
		this.description = description;
		this.cacheLoaderClassName = cacheLoaderClassName;
		this.refreshInterval = refreshInterval;
		this.preload = preload;
	}
	public String getCacheId()
	{
		return cacheId;
	}
	public String getDescription()
	{
		return description;
	}
	public String getCacheLoaderClassName()
	{
		return cacheLoaderClassName;
	}
	public long getRefreshInterval()
	{
		return refreshInterval;
	}
	
	public boolean isPreload()
	{
		return preload;
	}
	public void setRefreshInterval(long refreshInterval)
	{
		this.refreshInterval = refreshInterval;
	}
	public void setPreload(boolean preload)
	{
		this.preload = preload;
	}
	
}
