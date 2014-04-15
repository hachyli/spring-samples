package com.sivalabs.core.cache;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sivalabs.core.domain.Country;
import com.sivalabs.test.BaseTest;


public class CacheTest extends BaseTest
{
	CacheManager cacheManager = null;
	@Override
	public void before()
	{
		cacheManager = new CacheManagerImpl();
		super.before();
	}
	@Override
	public void after()
	{
		cacheManager = null;
		super.after();
	}
	
	@Test
	public void testCacheLoading() 
	{
		CountriesCache cache = (CountriesCache) cacheManager.getCache(CacheId.COUNTRIES_CACHE_ID);
		Assert.assertNotNull(cache);
		List<Country> countries = cache.getCacheData();
		Assert.assertNotNull(countries);
		for (Country country : countries) {
			System.out.println(country);
		}
	}

}
