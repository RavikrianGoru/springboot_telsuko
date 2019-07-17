package com.javabrains.springboot.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {
		// Starting point of SpringBoot app.
		// Start servlet container and host this app in servlet container.
		
		SpringApplication.run(CourseApiApp.class, args);
	}

}
