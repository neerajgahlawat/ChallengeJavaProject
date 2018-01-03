package com.app.challenge.java.service;

import java.util.Locale;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.app.challenge.java.DTO.UserDTO;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;

	@Override
	public void sendEmail(Object object) {

		UserDTO userDTO = (UserDTO) object;

		MimeMessagePreparator preparator = getMessagePreparator(userDTO);

		try {
			mailSender.send(preparator);
			System.out.println("Message Send...Hurrey");
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private MimeMessagePreparator getMessagePreparator(final UserDTO userDTO) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setFrom("customerserivces@yourshop.com");
				mimeMessage.setRecipient(Message.RecipientType.TO,
						new InternetAddress(userDTO.getEmail()));
				mimeMessage.setText("Dear " + userDTO.getFirstName()
						+ ", thank you.");
				mimeMessage.setSubject("Your order on Demoapp");
			}
		};
		return preparator;
	}

}
