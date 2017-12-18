package com.app.challenge.java.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ANSWER")
public class UserAnswerDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ANSWER_ID")
	private long userAnswerId;

	@Column(name = "USER_ANSWER", nullable = true)
	private String givenAnswer;

	@Column(name = "CREATED_DATE", nullable = true)
	private Date createdDate;

	@Column(name = "MODIFIED_DATE", nullable = true)
	private Date modifiedDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_QUESTION_ID", nullable = false)
	private UserQuestionDTO userQuestion = new UserQuestionDTO();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userAnswer")
	private Set<AnswerCommentDTO> answerComments = new HashSet<AnswerCommentDTO>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private UserDTO user = new UserDTO();

	public long getUserAnswerId() {
		return userAnswerId;
	}

	public void setUserAnswerId(long userAnswerId) {
		this.userAnswerId = userAnswerId;
	}

	public String getGivenAnswer() {
		return givenAnswer;
	}

	public void setGivenAnswer(String givenAnswer) {
		this.givenAnswer = givenAnswer;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public UserQuestionDTO getUserQuestion() {
		return userQuestion;
	}

	public void setUserQuestion(UserQuestionDTO userQuestion) {
		this.userQuestion = userQuestion;
	}

	public Set<AnswerCommentDTO> getAnswerComments() {
		return answerComments;
	}

	public void setAnswerComments(Set<AnswerCommentDTO> answerComments) {
		this.answerComments = answerComments;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
