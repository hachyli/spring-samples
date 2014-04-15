/**
 * 
 */
package com.sivalabs.core.cache.dynacache;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Siva
 *
 */
public class CacheVO
{
	private CacheConfigVO cacheConfigVO;
	private Object cache;
	private Date lastUpdatedTime;
	private Timer reloadTimer = null;
	
	public String getCacheId()
	{
		return this.cacheConfigVO.getCacheId();
	}
	public CacheVO(CacheConfigVO cacheConfigVO)
	{
		this.cacheConfigVO = cacheConfigVO;
		init();
	}
	
	private void init()
	{
		if(this.cacheConfigVO.isPreload())
		{
			this.loadCache();
			startReloadTimer();
		}
	}
	
	public final Object getCache()
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
	
	void loadCache()
	{
		this.load();
		this.startReloadTimer();
	}
	
	private void load()
	{
		System.out.println("Loading Cache["+this.getCacheId()+"] at "+new Date());
		try
		{
			String clazz = this.cacheConfigVO.getCacheLoaderClassName();
			CacheLoader cacheLoader = (CacheLoader) Class.forName(clazz).newInstance();
			Object cacheData = cacheLoader.loadCache();
			this.cache = cacheData;
			this.lastUpdatedTime = new Date();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Completed.");
	}
	
	void invalidate()
	{
		this.cache = null;
		this.lastUpdatedTime = null;
		//this.startReloadTimer();
	}
	
	private void startReloadTimer()
	{
		if(reloadTimer!= null)
		{
			reloadTimer.cancel();
		}
		reloadTimer = new Timer();
		Calendar calendar = Calendar.getInstance();
		Long interval = this.cacheConfigVO.getRefreshInterval();
		calendar.add(Calendar.MILLISECOND, (interval.intValue()));
		reloadTimer.schedule(new TimerTask(){
							@Override
							public void run()
							{
								load();
							}
						}, 
						calendar.getTime(), 
						this.cacheConfigVO.getRefreshInterval());
	}
}
