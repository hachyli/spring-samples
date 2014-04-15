/**
 * 
 */
package com.sivalabs.forum.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author skatam
 *
 */
public abstract class DomainObject
{
	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}
}
