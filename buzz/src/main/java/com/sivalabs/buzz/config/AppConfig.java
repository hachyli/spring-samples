/**
 * 
 */
package com.sivalabs.buzz.config;

/**
 * @author Siva
 *
 */
import java.util.Properties;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Siva
 *
 */
@Configuration
@ComponentScan(value="com.sivalabs.buzz", 
				excludeFilters = @Filter(type = FilterType.CUSTOM, value = { WebPackageFilter.class }))
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories("com.sivalabs.buzz.repositories")
public class AppConfig {

	private static final String JDBC_DRIVER_CLASSNAME = "jdbc.driverClassName";
	private static final String JDBC_URL = "jdbc.url";
	private static final String JDBC_USERNAME = "jdbc.username";
	private static final String JDBC_PASSWORD = "jdbc.password";

	private static final String HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";
	private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String ENTITY_PACKAGES_TO_SCAN = "entity.packages.to.scan";
	private static final String INITIALIZE_DATABASE = "initialize_database";


	@Resource
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getRequiredProperty(JDBC_DRIVER_CLASSNAME));
		dataSource.setUrl(env.getRequiredProperty(JDBC_URL));
		dataSource.setUsername(env.getRequiredProperty(JDBC_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(JDBC_PASSWORD));

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
		entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(ENTITY_PACKAGES_TO_SCAN));

		entityManagerFactoryBean.setJpaProperties(hibProperties());

		return entityManagerFactoryBean;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(HIBERNATE_DIALECT,	env.getRequiredProperty(HIBERNATE_DIALECT));
		properties.put(HIBERNATE_HBM2DDL,	env.getRequiredProperty(HIBERNATE_HBM2DDL));
		properties.put(HIBERNATE_SHOW_SQL, env.getRequiredProperty(HIBERNATE_SHOW_SQL));
		return properties;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	//@Bean
	public DataSourceInitializer dataSourceInitializer()
	{
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource("sql/buzz.sql"));
		dataSourceInitializer.setDataSource(dataSource());
		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		dataSourceInitializer.setEnabled(Boolean.valueOf(env.getRequiredProperty(INITIALIZE_DATABASE)));
		return dataSourceInitializer;
	}

}

class WebPackageFilter extends RegexPatternTypeFilter
{
    public WebPackageFilter() {
    	 super(Pattern.compile("com.sivalabs.buzz.web..*"));
    }
}