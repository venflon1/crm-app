package com.ra2ocde.springsecuritydemo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.ra2ocde.springsecuritydemo"})
@PropertySource(value = { "classpath:persistence-mysql.properties", 
												  "classpath:spring.properties"})
public class DemoAppConfig {
	private static final Logger log = Logger.getLogger(DemoAppConfig.class.getSimpleName());
	
	private static final String DEFAULT_PREFIX = "/WEB-INF/view/";
	private static final String DEFAULT_SUFFIX = ".jsp";
	
	 @Autowired
	 private Environment env;
	
	// define bean for  ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		log.info("Setting ViewResolver - START");
		// 1. create viewResolver
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// 2. set ViewResolver
		log.info(">>> spring.viewResolver.prefix=" + this.env.getProperty("spring.viewResolver.prefix"));
		viewResolver.setPrefix(this.env.getProperty("spring.viewResolver.prefix") != null? this.env.getProperty("spring.viewResolver.prefix"): DEFAULT_PREFIX);
		log.info(">>> spring.viewResolver.suffix=" + this.env.getProperty("spring.viewResolver.suffix"));
		viewResolver.setSuffix(this.env.getProperty("spring.viewResolver.suffix") != null? this.env.getProperty("spring.viewResolver.suffix"): DEFAULT_SUFFIX);
		
		return viewResolver;
	}
	
	// define bean for DataSource
	@Bean
	public DataSource dataSource() {
		log.info("Setting DataSource - START");
		// 1. create ConnectionPool
		ComboPooledDataSource connectionPool = new ComboPooledDataSource();
		
		try {
			Environment env = this.env;
			// 2. set JDBC Properties
			this.setJdbcProperties(connectionPool, env);
			
			// 3. set specific Connection Pool properties
			this.setConnectioPoolProperties(connectionPool, env);
		} catch (PropertyVetoException ex) {
			new RuntimeException("Error in the jdbc driver name", ex);
			log.info("class:  " + DemoAppConfig.class.getSimpleName() + 
							" - " + ex.getMessage() +
							" - Error to setting driverName. Please verify the name of jdbc driver");
		}
		return connectionPool;
	}
	
	private void setJdbcProperties(ComboPooledDataSource connectionPool, Environment env) throws PropertyVetoException {
		log.info(">>> jdbc.driverName=" + env.getProperty("jdbc.driverName"));
		connectionPool.setDriverClass(env.getProperty("jdbc.driverName"));
		log.info(">>> jdbc.url=" + env.getProperty("jdbc.url")); 
		connectionPool.setJdbcUrl((env.getProperty("jdbc.url")));
		connectionPool.setUser(env.getProperty("jdbc.username"));
		connectionPool.setPassword(env.getProperty("jdbc.password"));
	}
	
	private void setConnectioPoolProperties(ComboPooledDataSource connectionPool,  Environment env) {
		log.info(">>> connectionPool.initialPoolSize=" + env.getProperty("connectionPool.initialPoolSize")); 
		connectionPool.setInitialPoolSize(env.getProperty("connectionPool.initialPoolSize") != null? Integer.parseInt(env.getProperty("connectionPool.initialPoolSize")): 5);
		log.info(">>> connectionPool.minPoolSize=" + env.getProperty("connectionPool.minPoolSize")); 
		connectionPool.setMinPoolSize(env.getProperty("connectionPool.minPoolSize") != null? Integer.parseInt(env.getProperty("connectionPool.minPoolSize")): 5);
		log.info(">>> connectionPool.maxPoolSize=" + env.getProperty("connectionPool.maxPoolSize")); 
		connectionPool.setMaxPoolSize(env.getProperty("connectionPool.maxPoolSize") != null? Integer.parseInt(env.getProperty("connectionPool.maxPoolSize")): 20);
		log.info(">>> connectionPool.maxIddleTime=" + env.getProperty("connectionPool.maxIddleTime")); 
		connectionPool.setMaxIdleTime(env.getProperty("connectionPool.maxIddleTime") != null? Integer.parseInt(env.getProperty("connectionPool.maxIddleTime")): 3000);
	}
}
