package com.Flight_reservation_app.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	
	@Autowired
	private JavaMailSender email;

	public void sendEmail(String to,String filePath) {
		MimeMessage message = email.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			
			helper.setTo(to);
helper.setSubject("Flight Itinerary" );
helper.setText("Please Download Attachment");

helper.addAttachment("Itinerary", new File(filePath));
			
email.send(message);


		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
