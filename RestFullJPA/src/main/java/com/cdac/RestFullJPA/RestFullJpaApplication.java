package com.cdac.RestFullJPA;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cdac.RestFullJPA.entity.User;
import com.cdac.RestFullJPA.respo.UserRepository;

@SpringBootApplication(scanBasePackages = "com.cdac.RestFullJPA.controller")
@EntityScan(basePackages = {"com.cdac.RestFullJPA.entity"})
@EnableJpaRepositories(basePackages = {"com.cdac.RestFullJPA.respo"})
public class RestFullJpaApplication implements CommandLineRunner{

	@Autowired
	UserRepository uRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(RestFullJpaApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		Optional<User> u = uRepo.findById("bhumur");
		System.out.println(u.get());
	}

}
