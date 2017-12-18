package com.app.challenge.java.service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.challenge.java.DAO.UserDao;
import com.app.challenge.java.DAO.UserProfileDao;
import com.app.challenge.java.DTO.UserDTO;
import com.app.challenge.java.DTO.UserProfileDTO;
import com.app.challenge.java.model.SignUp;
import com.app.challenge.java.util.UserProfileType;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserProfileDao userProfileDao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public UserDTO findById(int id) {
		return userDao.findById(id);
	}

	public UserDTO findBySSO(String sso) {
		UserDTO user = userDao.findBySSO(sso);
		return user;
	}

	public void saveUser(UserDTO user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(UserDTO user) {
		UserDTO entity = userDao.findById(user.getId());
		if(entity!=null){
			entity.setSsoId(user.getSsoId());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
		}
	}

	
	public void deleteUserBySSO(String sso) {
		userDao.deleteBySSO(sso);
	}

	public List<UserDTO> findAllUsers() {
		return userDao.findAllUsers();
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		UserDTO user = findBySSO(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
	@Override
	@Transactional
	public String setUserSignUp(SignUp signUp) {
		String response = null;
		UserDTO userDTO	= SignUp.convertToDTO(signUp);
		UserDTO isUserExists = findBySSO(userDTO.getSsoId());
		if(isUserExists == null){
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			userDTO.setFirstName(userDTO.getSsoId());
			userDTO.setLastName(userDTO.getSsoId());
			Set<UserProfileDTO> userProfileDTOs = new HashSet<UserProfileDTO>();
			UserProfileDTO userProfileDTO = userProfileDao.findByType(UserProfileType.USER.getUserProfileType());
			if(userProfileDTO == null){
				userProfileDTOs.add(new UserProfileDTO());
			}else{
				userProfileDTOs.add(userProfileDTO);
			}
			userDTO.setUserProfiles(userProfileDTOs);
			Integer identification = userDao.setUserSignUp(userDTO);
			if(identification != null && identification > 0){
				response ="Thanks! You have successfully signed up.";
			}else{
				response ="Sorry! You have not signed up successfully! Try Again.";
			}
		}else{
			response ="Sorry! User Already Exists! Try Another User Name.";
		}
		return response;
	}
	
	public boolean findBySSOIsExists(String user){
		boolean isExists = false;
		UserDTO userDTO = findBySSO(user);
		if(userDTO != null){
			isExists = true;
		}
		return isExists;
	}
	
}