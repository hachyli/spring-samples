/**
 * 
 */
package com.sivalabs.core.cache;

import java.util.ArrayList;
import java.util.List;

import com.sivalabs.core.domain.Country;

/**
 * @author siva
 *
 */
public class CountriesCache extends Cache<List<Country>> 
{
	@Override
	public List<Country> getCacheData() 
	{
		System.out.println("Loading CountriesCache data....");
		List<Country> countries = new ArrayList<Country>();
		countries.add(new Country(1, "India"));
		countries.add(new Country(1, "USA"));
		System.out.println("Loading CountriesCache data completed.");
		return countries;
	}

}
