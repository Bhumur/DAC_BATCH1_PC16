package com.cdac.MailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.cdac.MailSender.Service.EmailSenderService;

@SpringBootApplication
public class MailSenderApplication {
	
	@Autowired
	EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(MailSenderApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		emailSenderService.sendEmail("agrawalbhumur@gmail.com", "Hello", "Form Spring Boot");
	}

}
