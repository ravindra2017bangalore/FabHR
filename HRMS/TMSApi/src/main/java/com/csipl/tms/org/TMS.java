package com.csipl.tms.org;



import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.velocity.VelocityEngineFactory;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.csipl.common.model.Notification;
import com.csipl.common.services.notification.NotificationServices;


@Configuration
@EnableWebMvc
@EnableAutoConfiguration 
@EnableConfigurationProperties
@EnableCaching
@SpringBootApplication(scanBasePackages={"com.csipl.tms.*","com.csipl.common.*","com.csipl.common.*.*","com.csipl.hrms.*"}  )

//@EnableDiscoveryClient


public class TMS implements CommandLineRunner {

	// @Autowired
	//private CacheManager cacheManager;
	 
	 /*@Autowired
	 NotificationServices notificationServices;*/
	 
	public static void main(String[] args) {
		SpringApplication.run(TMS.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		//Notification notification =  notificationServices.getNotification(28l);
		//System.out.println(" notification.getNotificationId() ======   "+notification.getNotificationId());
		
		
	}
	 @Bean
	    public VelocityEngine getVelocityEngine() throws VelocityException, IOException {
	        VelocityEngineFactory velocityEngineFactory = new VelocityEngineFactory();
	        Properties props = new Properties();
	        props.put("resource.loader", "class");
	        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
	 
	        velocityEngineFactory.setVelocityProperties(props);
	        return velocityEngineFactory.createVelocityEngine();
	    }
	
	
}
