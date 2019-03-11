package com.csipl.hrms.org;






import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
//import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.velocity.VelocityEngineFactory;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;






@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableCaching
@SpringBootApplication(scanBasePackages={"com.csipl.hrms.*","com.csipl.common.*"})
//@EnableDiscoveryClient
public class HRMS implements CommandLineRunner {

	
	 
	 
	public static void main(String[] args) {
		SpringApplication.run(HRMS.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		
		
		
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
