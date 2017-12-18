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
@Table(name="USER_QUESTION_COMMENT")
public class QuestionCommentDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_QUESTION_COMMENT_ID")
	private long userQuestionCommentId;
	
	@Column(name = "QUESTION_COMMENT")
	private String questionComment;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_QUESTION_ID", nullable = false)
	private UserQuestionDTO userQuestion = new UserQuestionDTO();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private UserDTO user = new UserDTO();

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public UserQuestionDTO getUserQuestion() {
		return userQuestion;
	}

	public void setUserQuestion(UserQuestionDTO userQuestion) {
		this.userQuestion = userQuestion;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
