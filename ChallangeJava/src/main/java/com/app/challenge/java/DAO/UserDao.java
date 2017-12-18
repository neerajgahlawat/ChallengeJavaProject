package com.app.challenge.java.DAO;

import java.util.List;

import com.app.challenge.java.DTO.UserDTO;

public interface UserDao {

	UserDTO findById(int id);

	UserDTO findBySSO(String sso);

	void save(UserDTO user);

	void deleteBySSO(String sso);

	List<UserDTO> findAllUsers();
	
	public Integer setUserSignUp(UserDTO userDTO);

}