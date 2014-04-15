/**
 * 
 */
package com.sivalabs.forum.util;

/**
 * @author skatam
 *
 */
public class StringUtil
{
	private StringUtil()
	{
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
	
	public static void println(Object object)
	{
		System.out.println("["+object+"]");
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
