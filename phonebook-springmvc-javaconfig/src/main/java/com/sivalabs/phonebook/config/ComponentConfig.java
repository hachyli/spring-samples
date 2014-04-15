/**
 * 
 */
package com.sivalabs.phonebook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Siva
 *
 */
@Configuration
@ComponentScan(basePackages="com.sivalabs.phonebook", 
	excludeFilters={@Filter(type = FilterType.ANNOTATION, value = Configuration.class)}
)
//@Import({WebConfig.class, ServicesConfig.class, PersistenceConfig.class})
@PropertySource("classpath:application.properties")
public class ComponentConfig
{
	
}
