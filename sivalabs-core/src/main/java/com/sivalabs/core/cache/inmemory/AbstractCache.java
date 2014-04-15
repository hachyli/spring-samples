/**
 * 
 */
package com.sivalabs.core.cache.inmemory;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Siva
 *
 */
public abstract class AbstractCache<T>
{
	private CacheConfigVO cacheConfigVO;
	private T cache;
	private Date lastUpdatedTime;
	
	protected AbstractCache()
	{
		init();
	}
	
	private void init()
	{
		this.cacheConfigVO = this.getCacheConfigVO();
		if(this.cacheConfigVO.isPreload())
		{
			this.loadCache();
		}
		this.triggerCacheReloadTask();
	}
	
	private void triggerCacheReloadTask()
	{
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
							@Override
							public void run()
							{
								loadCache();
							}
						}, 
						new Date(), 
						this.getCacheConfigVO().getRefreshInterval());
	}

	protected abstract T getCacheData();
	
	protected abstract CacheConfigVO getCacheConfigVO();

	protected T getCache()
	{
		boolean reload = this.needsToReload();
		if(reload)
		{
			this.loadCache();
		}
		return cache;
	}
	
	private boolean needsToReload()
	{
		if(cache == null || lastUpdatedTime == null){
			return true;
		}
		long refreshInterval = this.cacheConfigVO.getRefreshInterval();
		long now = new Date().getTime();
		long diff = (now - this.lastUpdatedTime.getTime());
		if(diff >= refreshInterval){
			return true;
		}
		return false;
	}
	
	private void loadCache()
	{
		System.out.println("Loading cache...");
		try
		{
			T cacheData = this.getCacheData();
			this.cache = cacheData;
			this.lastUpdatedTime = new Date();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Completed.");
	}
}

