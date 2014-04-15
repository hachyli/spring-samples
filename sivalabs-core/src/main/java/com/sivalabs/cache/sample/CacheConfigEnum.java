/**
 * 
 */
package com.sivalabs.cache.sample;

import com.sivalabs.core.cache.inmemory.CacheConfigVO;

/**
 * @author Siva
 * 
 */
public enum CacheConfigEnum
{
	CONFIGURATION_CACHE("CONFIGURATION_CACHE",
						"Cache holding global configuration parameters",
						"com.sivalabs.utilities.cache.ConfigurationCache",
						10*1000,// 10 seconds
						true),
	STATIC_DATA_CACHE("CONFIGURATION_CACHE",
						"Cache holding global configuration parameters",
						"com.sivalabs.utilities.cache.StaticDataCache",
						60*1000,//1 minute
						true)
						;
	
	private String cacheId;
	private String description;
	private String cacheLoaderClassName;
	private long refreshInterval;
	private boolean preload;
	
	private CacheConfigEnum(String cacheId, String description, 
							String cacheLoaderClassName, long refreshInterval, 
							boolean preload)
	{
		this.cacheId = cacheId;
		this.cacheLoaderClassName = cacheLoaderClassName;
		this.description = description;
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

	public CacheConfigVO getCacheConfigVO()
	{
		CacheConfigVO cacheConfigVO = new CacheConfigVO(
				getCacheId(),
				getDescription(),
				getCacheLoaderClassName(), 
				getRefreshInterval(), 
				isPreload()
				);
		/*CacheConfigVO cacheConfigVO = new CacheConfigVO();
		cacheConfigVO.setPreload(isPreload());
		cacheConfigVO.setRefreshInterval(getRefreshInterval());*/
		return cacheConfigVO;
	}
	
}
