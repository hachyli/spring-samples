/**
 * 
 */
package com.sivalabs.core.cache.dynacache;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siva
 *
 */
public class CacheConfiguration
{
	private String cacheGroupName;
	private long defaultCacheRefreshInterval = CacheConstants.DEFAULT_CACHE_REFRESH_INTERVAL;
	private boolean defaultLazyLoad = CacheConstants.DEFAULT_CACHE_LAZY_LOAD;
	private List<CacheConfigVO> cacheConfigVOs = new ArrayList<CacheConfigVO>();
	public String getCacheGroupName()
	{
		return cacheGroupName;
	}
	public void setCacheGroupName(String cacheGroupName)
	{
		this.cacheGroupName = cacheGroupName;
	}
	public long getDefaultCacheRefreshInterval()
	{
		return defaultCacheRefreshInterval;
	}
	public void setDefaultCacheRefreshInterval(long defaultCacheRefreshInterval)
	{
		this.defaultCacheRefreshInterval = defaultCacheRefreshInterval;
	}
	public boolean isDefaultLazyLoad()
	{
		return defaultLazyLoad;
	}
	public void setDefaultLazyLoad(boolean defaultLazyLoad)
	{
		this.defaultLazyLoad = defaultLazyLoad;
	}
	public List<CacheConfigVO> getCacheConfigVOs()
	{
		return cacheConfigVOs;
	}
	public void addCacheConfigVO(CacheConfigVO cacheConfigVO)
	{
		this.cacheConfigVOs.add(cacheConfigVO);
	}
	public void addCacheConfigVOs(List<CacheConfigVO> cacheConfigVOs)
	{
		this.cacheConfigVOs.addAll(cacheConfigVOs);
	}
	
}
