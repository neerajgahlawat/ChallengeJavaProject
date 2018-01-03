package com.app.challenge.java.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.challenge.java.DTO.UserDTO;
import com.app.challenge.java.model.SignUp;
import com.app.challenge.java.model.User;

public interface UserService {

	UserDTO findById(int id);

	UserDTO findBySSO(String sso);

	void saveUser(UserDTO user);

	void updateUser(UserDTO user);

	void deleteUserBySSO(String sso);

	List<UserDTO> findAllUsers();

	boolean isUserSSOUnique(Integer id, String sso);
	
	public String setUserSignUp(SignUp signUp);

	boolean findBySSOIsExists(String user);

	String findUserByEmail(String userEmail, HttpServletRequest request);

	String validatePasswordResetToken(long id, String token);

}