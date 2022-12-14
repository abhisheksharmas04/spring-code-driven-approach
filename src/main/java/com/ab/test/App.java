package com.ab.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ab.beans.WishMessageGenerator;
import com.ab.config.AppConfig;

public class App {
	public static void main(String[] args) {
		// create IOC container															// step-2 takes the configuration class
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// step-1 IOC container creation
		
		// get target class object
		// STEP-8 comes in internal cache of IOC container and seraches if "wmg" names bean is there or not
		// gets the object reference
		WishMessageGenerator wmg = ctx.getBean("wmg", WishMessageGenerator.class);
		
		// invoke business method
		// STEP-9 Call the business method
		System.out.println(wmg.generateWishMessage("Abhishek"));
		
		// close container
		// STEP-10 end of the container
		ctx.close();
	}
}

/*step--7 after bean injection IOC container will create the internal cache and keeps the
 both class reference with bean id*/