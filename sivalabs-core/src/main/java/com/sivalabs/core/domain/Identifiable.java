package com.sivalabs.core.domain;

import java.io.Serializable;

/**
 * @author SivaLabs
 *
 */
public interface Identifiable<K> extends Serializable
{
	public void setId(K id);
	public K getId();
}
