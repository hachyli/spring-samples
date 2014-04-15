/**
 * 
 */
package com.sivalabs.core.utils;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author skatam
 *
 */
public class JndiUtils
{
	public static Context getInitialContext(Properties properties)
	{
		try
		{
			return new InitialContext(properties);
		} catch (NamingException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static Context getDefaultJBossJndiContext()
	{
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		properties.put(Context.PROVIDER_URL, "localhost:1099");
		
		return getInitialContext(properties);
		
	}
	
	public static <T> T lookup(Context context, String jndiName, Class<T> clazz)
	{
		try
		{
			return clazz.cast(context.lookup(jndiName));
		} catch (NamingException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
