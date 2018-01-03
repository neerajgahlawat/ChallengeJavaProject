package com.app.challenge.java.model;

import org.modelmapper.ModelMapper;

import com.app.challenge.java.DTO.AnswerCommentDTO;
import com.app.challenge.java.DTO.QuestionCommentDTO;

public class AnswerComment {

	private long answerCommentId;
	
	private String answerComment;
	
	private long answerId;
	
	private long questionId;
	
	private String created_Date;

	private String givenBy;

	public long getAnswerCommentId() {
		return answerCommentId;
	}

	public void setAnswerCommentId(long answerCommentId) {
		this.answerCommentId = answerCommentId;
	}

	public String getAnswerComment() {
		return answerComment;
	}

	public void setAnswerComment(String answerComment) {
		this.answerComment = answerComment;
	}

	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
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

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
	public static AnswerCommentDTO convertToDTO(AnswerComment answerComment) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(answerComment, AnswerCommentDTO.class);
	}
}
