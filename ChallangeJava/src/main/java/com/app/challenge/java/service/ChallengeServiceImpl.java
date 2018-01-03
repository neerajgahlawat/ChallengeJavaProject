package com.app.challenge.java.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.challenge.java.DAO.ChallengeDAO;
import com.app.challenge.java.DAO.QuestionCommentDAO;
import com.app.challenge.java.DAO.UserAnswerDAO;
import com.app.challenge.java.DAO.UserDao;
import com.app.challenge.java.DAO.UserQuestionDAO;
import com.app.challenge.java.DTO.AnswerCommentDTO;
import com.app.challenge.java.DTO.NotifyDTO;
import com.app.challenge.java.DTO.QuestionCommentDTO;
import com.app.challenge.java.DTO.UserAnswerDTO;
import com.app.challenge.java.DTO.UserDTO;
import com.app.challenge.java.DTO.UserQuestionDTO;
import com.app.challenge.java.DTO.UserQuestionTagDTO;
import com.app.challenge.java.model.AnswerComment;
import com.app.challenge.java.model.AskQuestion;
import com.app.challenge.java.model.Notify;
import com.app.challenge.java.model.QuestionComment;
import com.app.challenge.java.model.UserAnswer;
import com.app.challenge.java.util.UserDetailsUtil;

@Service("challengeService")
public class ChallengeServiceImpl implements ChallengeService {

	private final static Logger logger = Logger
			.getLogger(ChallengeServiceImpl.class);

	@Autowired
	ChallengeDAO challengeDAO;

	@Autowired
	UserQuestionDAO userQuestionDAO;

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserAnswerDAO userAnswerDAO;
	
	@Autowired
	QuestionCommentDAO questionCommentDAO;

	@Override
	@Transactional
	public String setNotifyMe(Notify notify) {
		String msg = null;
		logger.info("In service");
		NotifyDTO notifyDTO = Notify.convertToDTO(notify);
		List<NotifyDTO> notifyDTOs = challengeDAO.getNotifyMe(notifyDTO);
		if (notifyDTOs == null || notifyDTOs.isEmpty()) {
			challengeDAO.setNotifyMe(notifyDTO);
			msg = "Thanks for notify us!";
		} else {
			msg = "Email or Phone already exist";
		}
		return msg;
	}

	@Override
	@Transactional
	public void askQuestion(AskQuestion askQuestion) {
		UserQuestionDTO userQuestionDTO = AskQuestion.convertToDTO(askQuestion);
		UserDTO userDTO = userDao.findBySSO(UserDetailsUtil.getPrincipal());
		userQuestionDTO.setUser(userDTO);
		userQuestionDTO.setUserQuestionTags(getUserQuestionTagSet(askQuestion
				.getQuestion_tag()));
		userQuestionDAO.saveAskQuestion(userQuestionDTO);
	}

	private Set<UserQuestionTagDTO> getUserQuestionTagSet(String questionTags) {
		List<UserQuestionTagDTO> userQuestionTagDTOs = challengeDAO
				.getAllUserQuestionTags();
		Set<UserQuestionTagDTO> userQuestionTagsSet = new HashSet<UserQuestionTagDTO>();
		if (questionTags != null && questionTags.contains(",")) {
			String[] tags = questionTags.split(",");
			for (String tag : tags) {
				UserQuestionTagDTO userQuestionTags1 = getUserQuestionTagDTO(
						userQuestionTagDTOs, tag);

				if (userQuestionTags1 == null) {
					logger.info("---------------------user question tag not found----------------------");
					UserQuestionTagDTO userQuestionTags2 = new UserQuestionTagDTO();
					userQuestionTags2.setQuestionTag(tag.toUpperCase());
					userQuestionTagsSet.add(userQuestionTags2);
				} else {
					logger.info("---------------------user question tag found---------------------- "
							+ userQuestionTags1.getQuestionTag());
					userQuestionTagsSet.add(userQuestionTags1);
				}

			}
		} else if (questionTags != null) {
			UserQuestionTagDTO userQuestionTags1 = getUserQuestionTagDTO(
					userQuestionTagDTOs, questionTags);
			if (userQuestionTags1 == null) {
				logger.info("---------------------user question tag not found----------------------");
				UserQuestionTagDTO userQuestionTags2 = new UserQuestionTagDTO();
				userQuestionTags2.setQuestionTag(questionTags.toUpperCase());
				userQuestionTagsSet.add(userQuestionTags2);
			} else {
				logger.info("---------------------user question tag found---------------------- "
						+ userQuestionTags1.getQuestionTag());
				userQuestionTagsSet.add(userQuestionTags1);
			}
		}
		return userQuestionTagsSet;
	}

	private UserQuestionTagDTO getUserQuestionTagDTO(
			List<UserQuestionTagDTO> userQuestionTagDTOs, String tag) {
		for (UserQuestionTagDTO userQuestionTagDTO : userQuestionTagDTOs) {
			if (userQuestionTagDTO.getQuestionTag().toUpperCase()
					.equals(tag.toUpperCase())) {
				return userQuestionTagDTO;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public List<AskQuestion> getAskedQuestionList() {
		return AskQuestion.convertDtoToModelList(userQuestionDAO
				.getAskedQuestionList());
	}

	@Override
	@Transactional
	public List<AskQuestion> getAllAskedQuestionList() {
		return AskQuestion.convertDtoToModelList(userQuestionDAO
				.getAllAskedQuestionList());
	}

	@Override
	@Transactional
	public AskQuestion getQuestionById(String questionId) {
		UserQuestionDTO userQuestionDTO = userQuestionDAO.getQuestionById(questionId);
		List<UserAnswerDTO> userAnswerDTOs = userAnswerDAO.getAllAnswerByQuestionId(questionId);
		for (UserAnswerDTO userAnswerDTO : userAnswerDTOs) {
			List<AnswerCommentDTO> answerCommentDTOs = questionCommentDAO.getAllAnswerCommentById(userAnswerDTO.getUserAnswerId());
			userAnswerDTO.setAnswerComments(answerCommentDTOs);
		}
		List<QuestionCommentDTO> commentDTOs =questionCommentDAO.getAllQuestionCommentById(questionId);
		userQuestionDTO.setUserAnswers(userAnswerDTOs);
		userQuestionDTO.setQuestionComments(commentDTOs);
		return AskQuestion.convertDtoToModel(userQuestionDTO);
	}

	@Override
	@Transactional
	public void insertUserAnswer(UserAnswer userAnswer) {
		UserAnswerDTO userAnswerDTO = new UserAnswerDTO();
		userAnswerDTO.setGivenAnswer(userAnswer.getGivenAnswer());
		UserQuestionDTO userQuestionDTO = userQuestionDAO.getQuestionById(String.valueOf(userAnswer.getUserQuestionId()));
		if(userQuestionDTO != null){
			userAnswerDTO.setUserQuestion(userQuestionDTO);
		}else{
			logger.error("------------------user question not found by user question id------------");
		}
		UserDTO userDTO = userDao.findBySSO(UserDetailsUtil.getPrincipal());
		if(userDTO != null){
			userAnswerDTO.setUser(userDTO);
		}else{
			logger.error("------------------user  not found by user ssoid-----------");
			
		}
		userQuestionDAO.insertUserAnswer(userAnswerDTO);
	}

	@Override
	@Transactional
	public void setUserQuestionComment(QuestionComment questionComment) {
		 QuestionCommentDTO questionCommentDTO = QuestionComment.convertToDTO(questionComment);
		 UserQuestionDTO userQuestionDTO = userQuestionDAO.getQuestionById(String.valueOf(questionComment.getQuestionId()));
		 if(userQuestionDTO != null){
			 questionCommentDTO.setUserQuestion(userQuestionDTO);
			}else{
				logger.error("------------------user question not found by user question id------------");
			}
		 UserDTO userDTO = userDao.findBySSO(UserDetailsUtil.getPrincipal());
			if(userDTO != null){
				questionCommentDTO.setUser(userDTO);
			}else{
				logger.error("------------------user  not found by user ssoid-----------");
				
			}
			questionCommentDAO.insertUserQuestionComment(questionCommentDTO);
			
	}

	@Override
	@Transactional
	public void setUserAnswerComment(AnswerComment answerComment) {
		AnswerCommentDTO answerCommentDTO = AnswerComment.convertToDTO(answerComment);
		UserAnswerDTO userAnswerDTO = userQuestionDAO.getAnswerById(answerComment.getAnswerId());
		if(userAnswerDTO != null){
			answerCommentDTO.setUserAnswer(userAnswerDTO);
		}else{
			logger.error("------------------user answer not found by user answer id------------");
		}
		UserDTO userDTO = userDao.findBySSO(UserDetailsUtil.getPrincipal());
		if(userDTO != null){
			answerCommentDTO.setUser(userDTO);
		}else{
			logger.error("------------------user  not found by user ssoid-----------");
		}
		questionCommentDAO.insertUserAnswerComment(answerCommentDTO);
	}

}
