package com.app.challenge.java.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.app.challenge.java.DTO.UserAnswerDTO;

@Repository("userAnswerDAO")
public class UserAnswerDAOImpl extends AbstractDao<Integer, UserAnswerDTO>
		implements UserAnswerDAO {

	private final static Logger logger = Logger
			.getLogger(UserAnswerDAOImpl.class);

	@Override
	public List<UserAnswerDTO> getAllAnswerByQuestionId(String questionId) {
		List<UserAnswerDTO> userAnswerDTOs = null;
		try {
			String queryStr = "select userAnswer from UserAnswerDTO userAnswer where  userAnswer.userQuestion.userQuestionId = :questionId";
			Query query = this.getSession().createQuery(queryStr);
			query.setParameter("questionId", Long.valueOf(questionId));
			userAnswerDTOs = (List<UserAnswerDTO>) query.list();
		} catch (Exception exception) {
			logger.error("error in get All Answer By Question Id", exception);
		}
		return userAnswerDTOs;
	}
}
