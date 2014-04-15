/**
 * 
 */
package com.sivalabs.core.cache;

import java.util.Date;

/**
 * @author siva
 *
 */
public abstract class Cache<T>
{
	private CacheId cacheId;
	private String cacheName;
	private long ttl;
	private boolean preload;
	
	private Date expireAt = null;
	private T data;
	
	public abstract T getCacheData() ;

	public void load() 
	{
		this.data = getCacheData();		
	}
	
	protected T getData(){
		return this.data;
	}

	public CacheId getCacheId() {
		return cacheId;
	}
	public void setCacheId(CacheId cacheId) {
		this.cacheId = cacheId;
	}
	public String getCacheName() {
		return cacheName;
	}
	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}
	public long getTtl() {
		return ttl;
	}
	public void setTtl(long ttl) {
		this.ttl = ttl;
		this.expireAt = new Date(System.currentTimeMillis() + ttl);
	}
	public boolean isPreload() {
		return preload;
	}
	public void setPreload(boolean preload) {
		this.preload = preload;
	}
	public boolean isExpired() {
		Date now = new Date();
		return now.after(this.expireAt);
	}
	
}
