package com.app.challenge.java.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ANSWER_COMMENT")
public class AnswerCommentDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ANSWER_COMMENT_ID")
	private long answerCommentId;

	@Column(name = "ANSWER_COMMENT")
	private String answerComment;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	private Date modifiedDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ANSWER_ID", nullable = false)
	private UserAnswerDTO userAnswer = new UserAnswerDTO();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private UserDTO user = new UserDTO();

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

	public UserAnswerDTO getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(UserAnswerDTO userAnswer) {
		this.userAnswer = userAnswer;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
