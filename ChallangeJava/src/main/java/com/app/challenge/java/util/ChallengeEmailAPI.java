package com.app.challenge.java.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.app.challenge.java.DTO.ContactDTO;

@Service("challengeEmailAPI")
public class ChallengeEmailAPI {

	@Autowired
	private MailSender mailSender; // MailSender interface defines a strategy
										// for sending simple mails
 
	public void readyToSendEmail(ContactDTO contactDTO) {
 
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("challengejava@gmail.com");
		mailMessage.setTo("challengejava@gmail.com");
		mailMessage.setSubject(contactDTO.getSubject()+" From Email "+contactDTO.getUsername());
		mailMessage.setText(contactDTO.getMessage()+" From Email " +contactDTO.getUsername());
		mailSender.send(mailMessage);
	}
}
