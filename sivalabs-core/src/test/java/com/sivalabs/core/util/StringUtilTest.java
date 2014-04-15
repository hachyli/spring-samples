/**
 * 
 */
package com.sivalabs.core.util;

import org.junit.Assert;
import org.junit.Test;

import com.sivalabs.core.utils.StringUtils;
import com.sivalabs.test.BaseTest;

/**
 * @author skatam
 *
 */
public class StringUtilTest extends BaseTest
{
	String[] strings = {null, "", "StringThree", null, "StringFive"};
	
	@Test
	public void testGetFirstNotNullValue()
	{
		String firstNotNullValue = StringUtils.getFirstNotNullValue(strings);
		Assert.assertNotNull(firstNotNullValue);
		System.out.println(firstNotNullValue);
	}
	
	@Test
	public void testGetFirstNotBlankValue()
	{
		String firstNotBlankValue = StringUtils.getFirstNotBlankValue(strings);
		Assert.assertNotNull(firstNotBlankValue);
		System.out.println(firstNotBlankValue);
	}
	
	@Test
	public void testPrint()
	{
		StringUtils.print("Abcd","efgh",null,"","Xyz");
	}
	
	@Test
	public void testPrintln()
	{
		StringUtils.println("Abcd","efgh",null,"","Xyz");
	}
}
