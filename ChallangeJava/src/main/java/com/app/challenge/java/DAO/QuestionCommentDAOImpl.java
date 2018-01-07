package com.app.challenge.java.DAO;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.app.challenge.java.DTO.AnswerCommentDTO;
import com.app.challenge.java.DTO.QuestionCommentDTO;
import com.app.challenge.java.DTO.UserAnswerDTO;

@Repository("questionCommentDAO")
public class QuestionCommentDAOImpl extends AbstractDao<Integer, QuestionCommentDTO> implements QuestionCommentDAO {
	
	private final static Logger logger = Logger
			.getLogger(QuestionCommentDAOImpl.class);

	
	public List<QuestionCommentDTO> getAllQuestionCommentById(String questionId) {
		List<QuestionCommentDTO> questionCommentDTOs = null;
		try {
			String queryStr = "select questionComment from QuestionCommentDTO questionComment where  questionComment.userQuestion.userQuestionId = :questionId";
			Query query = this.getSession().createQuery(queryStr);
			query.setParameter("questionId", Long.valueOf(questionId));
			questionCommentDTOs = (List<QuestionCommentDTO>) query.list();
		} catch (Exception exception) {
			logger.error("error in get All Answer By Question Id", exception);
		}
		return questionCommentDTOs;
	}

	public void insertUserQuestionComment(QuestionCommentDTO questionCommentDTO) {
		try{
			questionCommentDTO.setCreatedDate(new Date());
			questionCommentDTO.setUpdatedDate(new Date());
			this.getSession().saveOrUpdate(questionCommentDTO);
			}catch(Exception exception){
				System.out.println(exception);
			}
	}

	
	public void insertUserAnswerComment(AnswerCommentDTO answerCommentDTO) {
		try{
			answerCommentDTO.setCreatedDate(new Date());
			answerCommentDTO.setModifiedDate(new Date());
			this.getSession().saveOrUpdate(answerCommentDTO);
			}catch(Exception exception){
				System.out.println(exception);
			}
		
	}

	
	public List<AnswerCommentDTO> getAllAnswerCommentById(long answerId) {
		List<AnswerCommentDTO> answerCommentDTOs = null;
		try {
			String queryStr = "select answerComment from AnswerCommentDTO answerComment where  answerComment.userAnswer.userAnswerId = :answerId";
			Query query = this.getSession().createQuery(queryStr);
			query.setParameter("answerId", answerId);
			answerCommentDTOs = (List<AnswerCommentDTO>) query.list();
		} catch (Exception exception) {
			logger.error("error in get All Answer By Question Id", exception);
		}
		return answerCommentDTOs;
	}
}
