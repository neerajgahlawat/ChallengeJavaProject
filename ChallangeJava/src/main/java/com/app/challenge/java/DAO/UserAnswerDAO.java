package com.app.challenge.java.DAO;

import java.util.List;

import com.app.challenge.java.DTO.UserAnswerDTO;

public interface UserAnswerDAO {

	List<UserAnswerDTO> getAllAnswerByQuestionId(String questionId);

}
