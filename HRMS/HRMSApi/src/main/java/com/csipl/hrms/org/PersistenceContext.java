package com.csipl.hrms.org;

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

@EnableJpaRepositories({"com.csipl.hrms.service.*","com.csipl.common.services.*"})

@EnableTransactionManagement

public class PersistenceContext {
	
	 private  final String[] ENTITY_PACKAGES = {
	            "com.csipl.hrms.model.*","com.csipl.common.model"
	    };
	
	    private  final String PROPERTY_NAME_DB_DRIVER_CLASS = "db.driver";
	    private  final String PROPERTY_NAME_DB_PASSWORD = "db.password";
	    private  final String PROPERTY_NAME_DB_URL = "db.url";
	    private  final String PROPERTY_NAME_DB_USER = "db.username";
	    private  final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	    private  final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	    private  final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	    
	    private static final String PROPERTY_NAME_JNDI_NAME = "jndi.name";
	    
	    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";


	  @Bean
	  public DataSource dataSource( Environment env ) {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    
	    dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DB_DRIVER_CLASS));
	    dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DB_URL));
	    dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DB_USER));
	    dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DB_PASSWORD));
	    return dataSource;
	  }
	
	  
	 /* @Bean(destroyMethod="")
		public DataSource jndiDataSource( Environment env ) throws IllegalArgumentException, NamingException {
	
			JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
			bean.setJndiName( env.getRequiredProperty(PROPERTY_NAME_JNDI_NAME) );
			bean.setProxyInterface(DataSource.class);
			bean.setLookupOnStartup(false);
			bean.afterPropertiesSet();
			return (DataSource)bean.getObject();
		}*/
	  
	  @Bean
	    LocalContainerEntityManagerFactoryBean entityManagerFactory( DataSource dataSource, Environment env) {
	        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	        entityManagerFactoryBean.setDataSource(dataSource);
	    	entityManagerFactoryBean.setPersistenceUnitName("mySQL");
	        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);

	        Properties jpaProperties = new Properties();

	        //Configures the used database dialect. This allows Hibernate to create SQL
	        //that is optimized for the used database.
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));

	        //Specifies the action that is invoked to the database when the Hibernate
	        //SessionFactory is created or closed.
	        //jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));

	       
	        //If the value of this property is true, Hibernate writes all SQL
	        //statements to the console.
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

	        //If the value of this property is true, Hibernate will use prettyprint
	        //when it writes SQL to the console.
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));

	        entityManagerFactoryBean.setJpaProperties(jpaProperties);

	        return entityManagerFactoryBean;
	    }
	  

	  @Bean
	    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityManagerFactory);
	        return transactionManager;
	    }
	  
	  
	  
}
