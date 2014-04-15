/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.core.web.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import com.sivalabs.core.utils.HTTPUtils;

/**
 * @author K. Siva Prasad Reddy
 * Date : Aug 6, 2011 
 */
public class JSIncludeTag extends BaseTag
{
	private static final long serialVersionUID = 1L;
	
	private String path;
	
	@Override
	public int doStartTag() throws JspException
	{
		try
		{
			String absolutePath = HTTPUtils.getAbsolutePath(pageContext, this.path);
			String text = "<script type=\"text/javascript\" src=\""+absolutePath+"\"></script>";
			pageContext.getOut().write(text);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	
}
