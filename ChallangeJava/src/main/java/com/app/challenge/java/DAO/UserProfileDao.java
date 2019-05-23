package com.app.challenge.java.DAO;

import java.util.List;

import com.app.challenge.java.DTO.UserProfileDTO;

public interface UserProfileDao {

	List<UserProfileDTO> findAll();

	UserProfileDTO findByType(String type);

	UserProfileDTO findById(int id);
}
