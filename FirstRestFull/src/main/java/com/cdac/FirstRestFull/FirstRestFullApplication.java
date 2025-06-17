package com.cdac.FirstRestFull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cdac.FirstRestFull.controller"})
public class FirstRestFullApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstRestFullApplication.class, args);
	}

}
