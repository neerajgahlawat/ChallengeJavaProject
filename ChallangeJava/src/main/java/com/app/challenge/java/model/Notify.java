package com.app.challenge.java.model;

import org.modelmapper.ModelMapper;

import com.app.challenge.java.DTO.NotifyDTO;

public class Notify {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public static NotifyDTO convertToDTO(Notify notify){
		ModelMapper mapper = new ModelMapper();
		return mapper.map(notify, NotifyDTO.class);
	}
}
