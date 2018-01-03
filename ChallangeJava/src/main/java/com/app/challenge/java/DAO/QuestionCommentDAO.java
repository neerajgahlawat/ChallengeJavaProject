package com.app.challenge.java.DAO;

import java.util.List;

import com.app.challenge.java.DTO.AnswerCommentDTO;
import com.app.challenge.java.DTO.QuestionCommentDTO;

public interface QuestionCommentDAO {

	void insertUserQuestionComment(QuestionCommentDTO questionCommentDTO);

	List<QuestionCommentDTO> getAllQuestionCommentById(String questionId);

	void insertUserAnswerComment(AnswerCommentDTO answerCommentDTO);

	List<AnswerCommentDTO> getAllAnswerCommentById(long questionId);
}
