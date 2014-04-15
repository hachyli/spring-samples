package com.sivalabs.core.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author SivaLabs
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
