package com.app.challenge.java.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PASSWORD_RESET_TOKEN")
public class PasswordResetTokenDTO {

	private final static int EXPIRATION = 60 * 24;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long passwordResetTokenId;

	@Column(name = "TOKEN")
	private String token;

	@OneToOne(targetEntity = UserDTO.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "USER_ID")
	private UserDTO userDto = new UserDTO();

	@Column(name = "EXPIRY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;

	public long getPasswordResetTokenId() {
		return passwordResetTokenId;
	}

	public void setPasswordResetTokenId(long passwordResetTokenId) {
		this.passwordResetTokenId = passwordResetTokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}
}
