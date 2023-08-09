package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class ParkingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ParkingApplication.class, args);
	System.out.println(run.getBeanDefinitionCount()+"Dependencies Configured By Spring Boot***************************************");
	}
     
}
