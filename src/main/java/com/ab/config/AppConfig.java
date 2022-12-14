package com.ab.config;

import java.sql.DriverManager;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
               // step-4 go to @ComponentScan and takes the packages  
@ComponentScan(basePackages = "com.ab") // alternate to <contex:component-scan/>
@PropertySource(value="com/ab/comons/appProp.properties")
@ImportResource(locations="com/ab/cfg/applicationContext.xml")
public class AppConfig { // step-3 loads and creates the object of Configuration class
	
	@Autowired
	private Environment env; /*container created object*/
	/*properties file info comes and store into Environment object*/
	
	@Bean(name = "ldt")
	@Scope("prototype")
	public LocalDateTime createLocalDateTime() { // step--6 this method will execute
		/*this will create the object of LocalDateTime and injection takes place in @Component class @Autowired annotation*/
		System.out.println("AppConfig.createLocalDateTime()");
		/*we are froced to create spring bean class object and return to that object and
		@Bean takes the object and return it as a spring bean*/
		return LocalDateTime.now();
		
		/*This method is called automatically if the bean scope is single ton*/
	}
	
	@Bean(name="oraDs")
	public DriverManagerDataSource createDS() {
		DriverManagerDataSource drds = new DriverManagerDataSource();
		drds.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		drds.setUrl(env.getRequiredProperty("jdbc.url"));
		drds.setUsername(env.getRequiredProperty("jdbc.user.name"));
		drds.setPassword(env.getRequiredProperty("jdbc.password"));
		
		return drds;
	}

}
