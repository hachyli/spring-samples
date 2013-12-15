/**
 * 
 */
package com.sivalabs.springmvc.config;

import java.util.EnumSet;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

/**
 * @author Siva
 *
 */
/*
@WebListener
public class WebContainerInitializer implements ServletContainerInitializer
{

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx)
			throws ServletException {
		FilterRegistration.Dynamic reg =
				ctx.addFilter("SiteMeshFilter",
				"com.opensymphony.sitemesh.webapp.SiteMeshFilter");
		EnumSet<DispatcherType> disps = EnumSet.of(
                DispatcherType.REQUEST, DispatcherType.FORWARD);
				reg.addMappingForUrlPatterns(disps, true, "/*");
	}

}*/

