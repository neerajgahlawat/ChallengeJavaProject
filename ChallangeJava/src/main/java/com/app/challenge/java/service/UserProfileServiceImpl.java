package com.app.challenge.java.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.challenge.java.DAO.UserProfileDao;
import com.app.challenge.java.DTO.UserProfileDTO;


@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	UserProfileDao dao;
	
	public UserProfileDTO findById(int id) {
		return dao.findById(id);
	}

	public UserProfileDTO findByType(String type){
		return dao.findByType(type);
	}

	public List<UserProfileDTO> findAll() {
		return dao.findAll();
	}
}