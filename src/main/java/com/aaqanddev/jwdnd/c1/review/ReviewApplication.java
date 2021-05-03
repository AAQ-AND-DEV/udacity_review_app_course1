package com.aaqanddev.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

//	@Bean
//	public String message(){
//		System.out.println("message bean created");
//		return "Hello, Spring!";
//	}
//
//	@Bean
//	public String uppercaseMessage(MessageService ms){
//		System.out.println("uppercase message bean created");
//		return ms.uppercase();
//	}
//
//	@Bean String lowercaseMessage(MessageService ms){
//		System.out.println("lowercase message bean created");
//		return ms.lowercase();
//	}
}
