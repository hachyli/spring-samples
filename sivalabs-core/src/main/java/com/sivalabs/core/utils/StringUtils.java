/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.core.utils;

/**
 * @author K. Siva Prasad Reddy
 * Date : Aug 6, 2011
 */
public class StringUtils
{
	public static String stripStartingChars(String str, char c)
	{
		int len = str.length();
		for (int i = 0; i < len; i++)
		{
			if(str.charAt(i) != c)
			{
				return str.substring(i);
			}
		}
		return str;
	}
	
	public static String getFirstNotNullValue(String...strings)
	{
		for (String string : strings) 
		{
			if(string != null)
			{
				return string;
			}
		}
		return null;
	}
	
	public static String getFirstNotBlankValue(String...strings)
	{
		for (String string : strings) 
		{
			if(string != null && string.trim().length()>0)
			{
				return string;
			}
		}
		return null;
	}
	
	public static void print(String...strings)
	{
		for (String string : strings) 
		{
			System.out.print("["+string+"]");
		}
	}
	public static void println(String...strings)
	{
		for (String string : strings) 
		{
			System.out.println("["+string+"]");
		}
	}
}
