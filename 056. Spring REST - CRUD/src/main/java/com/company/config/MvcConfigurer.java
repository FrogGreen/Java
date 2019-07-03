package com.company.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.company")
@PropertySource({ "classpath:mysql.properties" })
public class MvcConfigurer implements WebMvcConfigurer {

	@Autowired
	private Environment environment;
	private Logger logger = Logger.getLogger(getClass().getName());

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
		comboPooledDataSource
				.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
		comboPooledDataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));
		comboPooledDataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
		comboPooledDataSource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));
		return comboPooledDataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		return properties;
	}


	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
		localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
		return localSessionFactoryBean;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
}