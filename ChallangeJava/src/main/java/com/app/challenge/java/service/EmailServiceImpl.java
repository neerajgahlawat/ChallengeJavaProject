package com.app.challenge.java.service;

import org.springframework.stereotype.Service;

import com.app.challenge.java.DTO.ContactDTO;
import com.app.challenge.java.model.Contact;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	@Override
	public String setContactUs(Contact contact) {
		ContactDTO contactDTO = Contact.convertToDTO(contact);
		return null;
	}

}
