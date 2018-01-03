package com.app.challenge.java.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.challenge.java.util.State;

@Entity
@Table(name = "APP_USER")
public class UserDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private int id;

	@Column(name = "SSO_ID", unique = true, nullable = false)
	private String ssoId;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name = "STATE", nullable = false)
	private String state = State.ACTIVE.getState();

	@ManyToMany(fetch = FetchType.EAGER ,cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.ALL})
	@JoinTable(name = "APP_USER_USER_PROFILE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
	private Set<UserProfileDTO> userProfiles = new HashSet<UserProfileDTO>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserQuestionDTO> userQuestions = new HashSet<UserQuestionDTO>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserAnswerDTO> userAnswers = new HashSet<UserAnswerDTO>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<QuestionCommentDTO> questionComments  = new HashSet<QuestionCommentDTO>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<AnswerCommentDTO> answerComments = new HashSet<AnswerCommentDTO>();
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<UserProfileDTO> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfileDTO> userProfiles) {
		this.userProfiles = userProfiles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserDTO))
			return false;
		UserDTO other = (UserDTO) obj;
		if (id != other.id)
			return false;
		if (ssoId == null) {
			if (other.ssoId != null)
				return false;
		} else if (!ssoId.equals(other.ssoId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", ssoId=" + ssoId + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", state=" + state + ", userProfiles="
				+ userProfiles + "]";
	}

	public Set<UserQuestionDTO> getUserQuestions() {
		return userQuestions;
	}

	public void setUserQuestions(Set<UserQuestionDTO> userQuestions) {
		this.userQuestions = userQuestions;
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

	public Set<AnswerCommentDTO> getAnswerComments() {
		return answerComments;
	}

	public void setAnswerComments(Set<AnswerCommentDTO> answerComments) {
		this.answerComments = answerComments;
	}
}