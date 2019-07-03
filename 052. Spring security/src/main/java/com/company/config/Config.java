package com.company.config;

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
@ComponentScan(basePackages = "com.company")
@PropertySource("classpath:mysql.properties")
public class Config {

	@Autowired
	private Environment environment;

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public DataSource dataSource() {
		// Connection pool
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

		// JDBC driver class
		try {
			comboPooledDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}

		// Log connection properties
		logger.info("---->> jdbc.url = " + environment.getProperty("jdbc.url") + " <<---");
		logger.info("---->> jdbc.user = " + environment.getProperty("jdbc.user") + " <<---");

		// JDBC connection properties
		comboPooledDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		comboPooledDataSource.setUser(environment.getProperty("jdbc.user"));
		comboPooledDataSource.setPassword(environment.getProperty("jdbc.password"));

		// Connection pool properties
		comboPooledDataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
		comboPooledDataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));
		comboPooledDataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
		comboPooledDataSource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));
		return comboPooledDataSource;
	}
}