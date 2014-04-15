/**
 * 
 */
package com.sivalabs.phonebook.utils;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Siva
 *
 */
public class CommonUtils
{
	private CommonUtils() {	}
	
	public static void print(Object object)
	{
		System.err.println(ToStringBuilder.reflectionToString(object));
	}
}
