package com.app.challenge.java.DAO;

import java.util.List;

import com.app.challenge.java.DTO.NotifyDTO;
import com.app.challenge.java.DTO.PasswordResetTokenDTO;
import com.app.challenge.java.DTO.UserDTO;
import com.app.challenge.java.DTO.UserQuestionTagDTO;


public interface ChallengeDAO {

	public void setNotifyMe(NotifyDTO notifyDTO);
	
	public List<NotifyDTO> getNotifyMe(NotifyDTO notifyDTO);

	public UserQuestionTagDTO findByTag(String question_tag);
	
	public List<UserQuestionTagDTO> getAllUserQuestionTags();

	public void setResetTokenForUser(PasswordResetTokenDTO myToken);

	public PasswordResetTokenDTO findByToken(String token);

	public PasswordResetTokenDTO getResetTokenByUserId(int id);

	public void updateUserPassword(UserDTO userDTO);

	public boolean deleteResetTokenForUser(Long userId);
}
