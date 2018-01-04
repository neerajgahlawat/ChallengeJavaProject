package com.app.challenge.java.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.challenge.java.DAO.ChallengeDAO;
import com.app.challenge.java.DAO.UserDao;
import com.app.challenge.java.DAO.UserProfileDao;
import com.app.challenge.java.DTO.PasswordResetTokenDTO;
import com.app.challenge.java.DTO.UserDTO;
import com.app.challenge.java.DTO.UserProfileDTO;
import com.app.challenge.java.model.SignUp;
import com.app.challenge.java.model.UpdatePassword;
import com.app.challenge.java.util.UserProfileType;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private final static Logger logger = Logger
			.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private ChallengeDAO challengeDAO;

	@Autowired
	private UserProfileDao userProfileDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MailService mailService;

	@Autowired
	JavaMailSender mailSender;

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
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	public void updateUser(UserDTO user) {
		UserDTO entity = userDao.findById(user.getId());
		if (entity != null) {
			entity.setSsoId(user.getSsoId());
			if (!user.getPassword().equals(entity.getPassword())) {
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
		return (user == null || ((id != null) && (user.getId() == id)));
	}

	@Override
	@Transactional
	public String setUserSignUp(SignUp signUp) {
		String response = null;
		UserDTO userDTO = SignUp.convertToDTO(signUp);
		UserDTO isUserExists = findBySSO(userDTO.getSsoId());
		if (isUserExists == null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			userDTO.setFirstName(userDTO.getSsoId());
			userDTO.setLastName(userDTO.getSsoId());
			Set<UserProfileDTO> userProfileDTOs = new HashSet<UserProfileDTO>();
			UserProfileDTO userProfileDTO = userProfileDao
					.findByType(UserProfileType.USER.getUserProfileType());
			if (userProfileDTO == null) {
				userProfileDTOs.add(new UserProfileDTO());
			} else {
				userProfileDTOs.add(userProfileDTO);
			}
			userDTO.setUserProfiles(userProfileDTOs);
			Integer identification = userDao.setUserSignUp(userDTO);
			if (identification != null && identification > 0) {
				response = "Thanks! You have successfully signed up.";
			} else {
				response = "Sorry! You have not signed up successfully! Try Again.";
			}
		} else {
			response = "Sorry! User Already Exists! Try Another User Name.";
		}
		return response;
	}

	public boolean findBySSOIsExists(String user) {
		boolean isExists = false;
		UserDTO userDTO = findBySSO(user);
		if (userDTO != null) {
			isExists = true;
		}
		return isExists;
	}

	@Override
	@Transactional
	public String findUserByEmail(String userEmail, HttpServletRequest request) {
		String response = null;
		UserDTO userDTO = userDao.findUserByEmail(userEmail);
		if (userDTO != null) {
			String token = UUID.randomUUID().toString();
			PasswordResetTokenDTO passwordResetTokenDTO = challengeDAO
					.getResetTokenByUserId(userDTO.getId());

			if (passwordResetTokenDTO != null) {
				passwordResetTokenDTO.setToken(token);
				passwordResetTokenDTO.setExpiryDate(getExpiryDate());
				challengeDAO.setResetTokenForUser(passwordResetTokenDTO);
			} else {
				PasswordResetTokenDTO myToken = new PasswordResetTokenDTO();
				myToken.setToken(token);
				myToken.setUserDto(userDTO);
				myToken.setExpiryDate(getExpiryDate());
				challengeDAO.setResetTokenForUser(myToken);
			}

			String contextPath = request.getContextPath();
			System.out.println(contextPath);
			StringBuffer stringBu = request.getRequestURL();
			System.out.println(stringBu);
			String uri = request.getRequestURI();
			System.out.println(uri);
			constructResetTokenEmail(request.getContextPath(),
					request.getLocale(), token, userDTO);
			response = "link has been sent to reset your password on your email address";
		} else {
			logger.info("User not found by email to reset password!");
			response = "User not found by email to reset password!";
		}
		return response;
	}

	private Date getExpiryDate() {
		Calendar cal = Calendar.getInstance(); // creates calendar
		cal.setTime(new Date()); // sets calendar time/date
		cal.add(Calendar.HOUR_OF_DAY, 1); // adds one hour
		return cal.getTime();

	}

	private SimpleMailMessage constructResetTokenEmail(String contextPath,
			Locale locale, String token, UserDTO userDTO) {
		String url = "http://localhost:8090" + contextPath
				+ "/user/changePassword?id=" + userDTO.getId() + "&token="
				+ token;
		System.out.println(url);
		/*
		 * String message = messages.getMessage("message.resetPassword", null,
		 * locale);
		 */
		String message = "reset Password";
		return constructEmail("Reset Password", message + " \r\n" + url,
				userDTO);
	}

	private SimpleMailMessage constructEmail(String subject, String body,
			UserDTO user) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setSubject(subject);
		email.setText(body);
		email.setTo(user.getEmail());
		email.setFrom("gahlawatneeraj3@gmail.com");
		return email;
	}

	@Override
	public String validatePasswordResetToken(long id, String token) {
		PasswordResetTokenDTO passToken = challengeDAO.findByToken(token);
		if ((passToken == null) || (passToken.getUserDto().getId() != id)) {
			return "invalidToken";
		}

		Calendar cal = Calendar.getInstance();
		if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			return "expired";
		}

		UserDTO userDTO = passToken.getUserDto();
		Authentication auth = new UsernamePasswordAuthenticationToken(userDTO,
				null, Arrays.asList(new SimpleGrantedAuthority(
						"CHANGE_PASSWORD_PRIVILEGE")));
		SecurityContextHolder.getContext().setAuthentication(auth);
		return null;
	}

	@Override
	@Transactional
	public String  updateUserPassword(UpdatePassword updatePassword, Long userId) {
		String response = "Your password has been updated succesfully!";
		UserDTO userDTO = userDao.findById(userId.intValue());
		userDTO.setPassword(passwordEncoder.encode(updatePassword.getPass()));
		challengeDAO.updateUserPassword(userDTO);
		challengeDAO.deleteResetTokenForUser(userId);
		return response;
	}
}