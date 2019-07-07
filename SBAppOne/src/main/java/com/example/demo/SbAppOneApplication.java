package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbAppOneApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SbAppOneApplication.class, args);
		System.out.println("Hello SpringBoot App");
		Learner obj1 = context.getBean(Learner.class);
		Learner obj2 = context.getBean(Learner.class);
		System.out.println(obj1.hashCode()+"----"+obj2.hashCode());
		obj1.show();
	}

}
