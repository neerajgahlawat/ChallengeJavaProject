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
@Table(name = "USER_QUESTION")
public class UserQuestionDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_QUESTION_ID")
	private long userQuestionId;

	@Column(name = "QUESTION_TITLE", nullable = false)
	private String question_title;

	@Column(name = "QUESTION_DESC", nullable = false)
	private String question_desc;

	@Column(name = "CREATED_DATE", nullable = false)
	private Date created_Date;

	@Column(name = "MODIFIED_DATE", nullable = false)
	private Date modified_Date;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private UserDTO user = new UserDTO();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userQuestion")
	private Set<UserAnswerDTO> userAnswers = new HashSet<UserAnswerDTO>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userQuestion")
	private Set<QuestionCommentDTO> questionComments = new HashSet<QuestionCommentDTO>();

	public long getUserQuestionId() {
		return userQuestionId;
	}

	public void setUserQuestionId(long userQuestionId) {
		this.userQuestionId = userQuestionId;
	}

	public String getQuestion_title() {
		return question_title;
	}

	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}

	public String getQuestion_desc() {
		return question_desc;
	}

	public void setQuestion_desc(String question_desc) {
		this.question_desc = question_desc;
	}

	public Date getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}

	public Date getModified_Date() {
		return modified_Date;
	}

	public void setModified_Date(Date modified_Date) {
		this.modified_Date = modified_Date;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Set<UserAnswerDTO> getUserAnswers() {
		return userAnswers;
	}

	public void setUserAnswers(Set<UserAnswerDTO> userAnswers) {
		this.userAnswers = userAnswers;
	}

	public Set<QuestionCommentDTO> getQuestionComments() {
		return questionComments;
	}

	public void setQuestionComments(Set<QuestionCommentDTO> questionComments) {
		this.questionComments = questionComments;
	}

}
