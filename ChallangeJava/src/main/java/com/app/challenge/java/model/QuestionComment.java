package com.app.challenge.java.model;

import org.modelmapper.ModelMapper;

import com.app.challenge.java.DTO.QuestionCommentDTO;
import com.app.challenge.java.DTO.UserQuestionDTO;

public class QuestionComment {

	private long userQuestionCommentId;
	
	private String questionComment;
	
	private long questionId;
	
	private String created_Date;

	private String givenBy;

	public long getUserQuestionCommentId() {
		return userQuestionCommentId;
	}

	public void setUserQuestionCommentId(long userQuestionCommentId) {
		this.userQuestionCommentId = userQuestionCommentId;
	}

	public String getQuestionComment() {
		return questionComment;
	}

	public void setQuestionComment(String questionComment) {
		this.questionComment = questionComment;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
	public String getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(String created_Date) {
		this.created_Date = created_Date;
	}

	public String getGivenBy() {
		return givenBy;
	}

	public void setGivenBy(String givenBy) {
		this.givenBy = givenBy;
	}

	public static QuestionCommentDTO convertToDTO(QuestionComment questionComment) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(questionComment, QuestionCommentDTO.class);
	}
}
