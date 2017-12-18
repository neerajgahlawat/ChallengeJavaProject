package com.app.challenge.java.model;

import org.modelmapper.ModelMapper;

import com.app.challenge.java.DTO.UserDTO;

public class SignUp {

	private long id;

	private String ssoId;

	private String email;

	private String password;

	private String password2;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	
	public static UserDTO convertToDTO(SignUp signUp) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(signUp, UserDTO.class);
	}
	 
}
