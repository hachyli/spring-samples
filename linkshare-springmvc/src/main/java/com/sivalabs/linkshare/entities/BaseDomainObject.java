/**
 * 
 */
package com.sivalabs.linkshare.entities;

import java.io.Serializable;

/**
 * @author skatam
 *
 */
public class BaseDomainObject implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return super.toString();
	}
}
