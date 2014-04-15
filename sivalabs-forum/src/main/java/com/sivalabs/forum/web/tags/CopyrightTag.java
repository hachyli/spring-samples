/**
 * 
 */
package com.sivalabs.forum.web.tags;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Calendar;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

/**
 * @author skatam
 *
 */
public class CopyrightTag extends TagSupport
{
	private static final long serialVersionUID = 1L;
	
	private String COPYRIGHT = "COPYRIGHT &#174; {0}. FTD INC. ALL RIGHTS RESERVED.";
	
	private String year;
	private String overrideContent;
	public int doStartTag() 
	{
		try 
		{
			JspWriter out = pageContext.getOut();			
			out.print(this.getCopyrightStatement());
		}
		catch(IOException ioe) {
			System.out.println("Error generating prime: " + ioe);
		}
		return(SKIP_BODY);
	}

	private String getCopyrightStatement()
	{
		if(!StringUtils.isEmpty(this.overrideContent))
		{
			return this.overrideContent;
		}
		return MessageFormat.format(COPYRIGHT, new Object[]{this.getYear()});
	}
	
	public String getYear()
	{
		if(StringUtils.isEmpty(this.year)){
			this.year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			System.out.println(this.year);
		}
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	public String getOverrideContent()
	{
		return overrideContent;
	}

	public void setOverrideContent(String overrideContent)
	{
		this.overrideContent = overrideContent;
	}
	
	
}
