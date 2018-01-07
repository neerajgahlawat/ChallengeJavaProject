package com.app.challenge.java.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.app.challenge.java.DTO.QuestionCommentDTO;
import com.app.challenge.java.DTO.UserAnswerDTO;
import com.app.challenge.java.DTO.UserQuestionDTO;
import com.app.challenge.java.util.UserDetailsUtil;

@Repository("userQuestionDAO")
public class UserQuestionDAOImpl extends AbstractDao<Integer, UserQuestionDTO>
		implements UserQuestionDAO {
	
	

	
	public void saveAskQuestion(UserQuestionDTO userQuestionDTO) {
		try {
			userQuestionDTO.setCreated_Date(new Date());
			userQuestionDTO.setModified_Date(new Date());
			this.getSession().saveOrUpdate(userQuestionDTO);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	
	public List<UserQuestionDTO> getAskedQuestionList() {
		List<UserQuestionDTO> userQuestionDTOs = null;
		try{
		String queryStr="select userQuestion from UserQuestionDTO userQuestion, UserDTO user where userQuestion.user = user.id and user.ssoId=:name order by userQuestion.userQuestionId desc";
		Query query = this.getSession().createQuery(queryStr);
		query.setParameter("name", UserDetailsUtil.getPrincipal());
		userQuestionDTOs =(List<UserQuestionDTO>) query.list();
		}catch (Exception exception) {
			exception.printStackTrace();
		}
		return userQuestionDTOs;
	}

	
	public List<UserQuestionDTO> getAllAskedQuestionList() {
		List<UserQuestionDTO> userQuestionDTOs = null;
		try{
		String queryStr="select userQuestion from UserQuestionDTO userQuestion, UserDTO user where userQuestion.user = user.id order by userQuestion.userQuestionId desc";
		userQuestionDTOs =(List<UserQuestionDTO>) this.getSession().createQuery(queryStr).list();
		}catch (Exception exception) {
			exception.printStackTrace();
		}
		return userQuestionDTOs;
	}

	
	public UserQuestionDTO getQuestionById(String questionId) {
		return (UserQuestionDTO) this.getSession().get(UserQuestionDTO.class, Long.parseLong(questionId));
	}

	
	public void insertUserAnswer(UserAnswerDTO userAnswerDTO) {
		try{
		userAnswerDTO.setCreatedDate(new Date());
		userAnswerDTO.setModifiedDate(new Date());
		this.getSession().saveOrUpdate(userAnswerDTO);
		}catch(Exception exception){
			System.out.println(exception);
		}
	}

	
	public UserAnswerDTO getAnswerById(long answerId) {
		return (UserAnswerDTO) this.getSession().get(UserAnswerDTO.class, answerId);
		
	}

	
}
