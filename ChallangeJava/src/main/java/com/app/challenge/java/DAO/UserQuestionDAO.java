package com.app.challenge.java.DAO;

import java.util.List;

import com.app.challenge.java.DTO.QuestionCommentDTO;
import com.app.challenge.java.DTO.UserAnswerDTO;
import com.app.challenge.java.DTO.UserQuestionDTO;

public interface UserQuestionDAO {

	void saveAskQuestion(UserQuestionDTO userQuestionDTO);

	List<UserQuestionDTO> getAskedQuestionList();

	List<UserQuestionDTO> getAllAskedQuestionList();

	UserQuestionDTO getQuestionById(String questionId);

	void insertUserAnswer(UserAnswerDTO userAnswerDTO);

	UserAnswerDTO getAnswerById(long answerId);

}
