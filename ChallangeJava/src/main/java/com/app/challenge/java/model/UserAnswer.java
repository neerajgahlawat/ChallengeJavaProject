package com.app.challenge.java.model;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.app.challenge.java.DTO.UserAnswerDTO;
import com.app.challenge.java.DTO.UserQuestionDTO;

public class UserAnswer {

	private Long userAnswerId; 
	
	private int userQuestionId;
	
	private String givenAnswer;
	
	private String created_Date;

	private String answeredAgo;

	private String givenBy;
	
	public List<AnswerComment> answerComments = new ArrayList<AnswerComment>();

	public Long getUserAnswerId() {
		return userAnswerId;
	}

	public void setUserAnswerId(Long userAnswerId) {
		this.userAnswerId = userAnswerId;
	}

	public int getUserQuestionId() {
		return userQuestionId;
	}

	public void setUserQuestionId(int userQuestionId) {
		this.userQuestionId = userQuestionId;
	}

	public String getGivenAnswer() {
		return givenAnswer;
	}

	public void setGivenAnswer(String givenAnswer) {
		this.givenAnswer = givenAnswer;
	}
	
	public String getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(String created_Date) {
		this.created_Date = created_Date;
	}

	public String getAnsweredAgo() {
		return answeredAgo;
	}

	public void setAnsweredAgo(String answeredAgo) {
		this.answeredAgo = answeredAgo;
	}

	public String getGivenBy() {
		return givenBy;
	}

	public void setGivenBy(String givenBy) {
		this.givenBy = givenBy;
	}

	public List<AnswerComment> getAnswerComments() {
		return answerComments;
	}

	public void setAnswerComments(List<AnswerComment> answerComments) {
		this.answerComments = answerComments;
	}

	public static UserAnswerDTO convertDtoToModel(UserAnswer userAnswer){
		ModelMapper mapper = new ModelMapper();
		return mapper.map(userAnswer, UserAnswerDTO.class);
	}
	
	
}
