/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.core.web.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author K. Siva Prasad Reddy
 * Date : Aug 6, 2011
 */
public class BaseTag extends TagSupport
{
	private static final long serialVersionUID = 1L;
	
	@Override
	public int doStartTag() throws JspException
	{
		return EVAL_BODY_INCLUDE;
	}
	@Override
	public int doEndTag() throws JspException
	{		
		return EVAL_PAGE;
	}
	
}
