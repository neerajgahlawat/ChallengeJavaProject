package com.app.challenge.java.service;

import java.util.List;

import com.app.challenge.java.DTO.UserProfileDTO;

public interface UserProfileService {

	UserProfileDTO findById(int id);

	UserProfileDTO findByType(String type);
	
	List<UserProfileDTO> findAll();
}
