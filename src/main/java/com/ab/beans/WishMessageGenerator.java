package com.ab.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
			// step-5 noticed that @Component class having singleton scope loads the class and creates the objects
public class WishMessageGenerator {
		// step-5 create the object of LocalDateTime and keep in the in-memory
	@Autowired
	private LocalDateTime date;
	/*PostProcess activate and searches for if there any LocalDateTime class are there or not
	if not there then automatically shifted to @Configuration class @Bean method whoes return
	type is LocalDateTime*/
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator.WishMessageGenerator():: 0 Param constuctor");
	}

	// Business Method
	public String generateWishMessage(String userName) {
		// get current hours
		int hours = date.getHour(); // 24 hours formate
		
		//generate wish message
		if(hours < 12)
			return "Good Morning " + userName;
		else if(hours < 16)
			return "Good Afternoon " + userName;
		else if(hours < 20)
			return "Good Goodevening " + userName;
		else
			return "Good Night " + userName;
	}

}
