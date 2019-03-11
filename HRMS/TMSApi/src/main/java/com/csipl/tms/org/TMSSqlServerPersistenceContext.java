package com.csipl.tms.org;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.csipl.sqlserver.repository")
@EnableTransactionManagement
public class TMSSqlServerPersistenceContext {
	
	private static final String[] ENTITY_PACKAGES = { "com.csipl.sqlserver.model.*" };
	
	private  final String PROPERTY_NAME_DB_DRIVER_CLASS_SQL_SERVER = "spring.datasource.driver";
	private  final String PROPERTY_NAME_DB_PASSWORD_SQL_SERVER = "spring.datasource.password";
	private  final String PROPERTY_NAME_DB_URL_SQL_SERVER = "spring.datasource.url";
	private  final String PROPERTY_NAME_DB_USER_SQL_SERVER = "spring.datasource.username";
	//private  final String PROPERTY_NAME_HIBERNATE_DIALECT_SQL_SERVER = "spring.sqlserver.jpa.hibernate.dialect";
	//private  final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL_SQL_SERVER = "true";
	//private  final String PROPERTY_NAME_HIBERNATE_SHOW_SQL_SQL_SERVER = "false";
	
	@Bean(name = "sqlServerDataSource")
	public DataSource sqlServerDataSource(Environment env) {
		DriverManagerDataSource sqlServerDataSource = new DriverManagerDataSource();

		sqlServerDataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DB_DRIVER_CLASS_SQL_SERVER));
		sqlServerDataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DB_URL_SQL_SERVER));
		sqlServerDataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DB_USER_SQL_SERVER));
		sqlServerDataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DB_PASSWORD_SQL_SERVER));
		return sqlServerDataSource;
	}
	
	@Bean(name = "sqlServerEntityManagerFactory")
	LocalContainerEntityManagerFactoryBean entityManagerFactory(  @Qualifier("sqlServerDataSource") DataSource sqlServerDataSource, Environment env) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(sqlServerDataSource);
		entityManagerFactoryBean.setPersistenceUnitName("sqlServer");
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect" , "org.hibernate.dialect.SQLServer2012Dialect");
		//jpaProperties.put("hibernate.show_sql", "false");
		//jpaProperties.put("hibernate.format_sql","false");
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		return entityManagerFactoryBean;
	}
	
	@Bean(name = "sqlServerTransactionManager")
	JpaTransactionManager transactionManager( final @Qualifier("sqlServerEntityManagerFactory") EntityManagerFactory sqlServerEntityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(sqlServerEntityManagerFactory);
		return transactionManager;
	}

}
