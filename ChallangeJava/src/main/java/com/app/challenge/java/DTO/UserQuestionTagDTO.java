package com.app.challenge.java.DTO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_QUESTION_TAG")
public class UserQuestionTagDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_QUESTION_TAG_ID")
	private int userQuestionTagId;

	@Column(name = "QUESTION_TAG", length = 15, unique = true, nullable = false)
	private String questionTag;

	@ManyToMany(mappedBy = "userQuestionTags", cascade = CascadeType.ALL)
	private Set<UserQuestionDTO> userQuestions = new HashSet<UserQuestionDTO>();

	public int getUserQuestionTagId() {
		return userQuestionTagId;
	}

	public void setUserQuestionTagId(int userQuestionTagId) {
		this.userQuestionTagId = userQuestionTagId;
	}

	public String getQuestionTag() {
		return questionTag;
	}

	public void setQuestionTag(String questionTag) {
		this.questionTag = questionTag;
	}

	public Set<UserQuestionDTO> getUserQuestions() {
		return userQuestions;
	}

	public void setUserQuestions(Set<UserQuestionDTO> userQuestions) {
		this.userQuestions = userQuestions;
	}
}
