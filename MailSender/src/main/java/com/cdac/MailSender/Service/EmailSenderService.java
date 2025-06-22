package com.cdac.MailSender.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	JavaMailSender mailSender;
	
	public void sendEmail(String toEmail, String subject, String body) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("bhumiragrawal9@gmail.com");
		mail.setTo(toEmail);
		mail.setSubject(subject);
		mail.setText(body);
		mailSender.send(mail);
		System.out.println("Mail sent");
	}

}
