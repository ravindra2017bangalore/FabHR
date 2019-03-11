package com.csipl.hrms.eureka.server;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
// @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class RegistrationServer {

	public static void main(String[] args) throws Exception {
		// Tell server to look for registration.properties or registration.yml
        // by default it looks for application.properties or application.yml
        System.setProperty("spring.config.name", "registration-server");
        
		SpringApplication.run(RegistrationServer.class, args);
	}

}
