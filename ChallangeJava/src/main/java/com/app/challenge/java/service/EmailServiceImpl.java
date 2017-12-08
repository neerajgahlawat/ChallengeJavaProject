package com.app.challenge.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.challenge.java.DTO.ContactDTO;
import com.app.challenge.java.model.Contact;
import com.app.challenge.java.util.ChallengeEmailAPI;

@Service("emailService")
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	ChallengeEmailAPI challengeEmailAPI;

	@Override
	public String setContactUs(Contact contact) {
		 ContactDTO contactDTO = Contact.convertToDTO(contact);
		 challengeEmailAPI.readyToSendEmail(contactDTO);
		return null;
	}

}
