package com.cdac.BootMVCHibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.cdac.BootMVCHibernate.controller"})
@EntityScan(basePackages = {"com.cdac.BootMVCHibernate.entity"})
public class BootMvcHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMvcHibernateApplication.class, args);
	}

}
