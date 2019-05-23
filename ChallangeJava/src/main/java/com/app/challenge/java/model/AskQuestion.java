package com.app.challenge.java.model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;

import com.app.challenge.java.DTO.AnswerCommentDTO;
import com.app.challenge.java.DTO.QuestionCommentDTO;
import com.app.challenge.java.DTO.UserAnswerDTO;
import com.app.challenge.java.DTO.UserDTO;
import com.app.challenge.java.DTO.UserQuestionDTO;
import com.app.challenge.java.DTO.UserQuestionTagDTO;

public class AskQuestion {

	public Long userQuestionId;

	public String question_title;

	public String question_desc;

	public String question_tag;

	private String created_Date;

	private String askedAgo;

	private String askedBy;

	public Set<String> userQuestionTags = new HashSet<String>();

	public List<UserAnswer> userAnswerGiven = new ArrayList<UserAnswer>();

	public List<QuestionComment> questionComments = new ArrayList<QuestionComment>();

	public Long getUserQuestionId() {
		return userQuestionId;
	}

	public void setUserQuestionId(Long userQuestionId) {
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

	public String getQuestion_tag() {
		return question_tag;
	}

	public void setQuestion_tag(String question_tag) {
		this.question_tag = question_tag;
	}

	public String getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(String created_Date) {
		this.created_Date = created_Date;
	}

	public static UserQuestionDTO convertToDTO(AskQuestion askQuestion) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(askQuestion, UserQuestionDTO.class);
	}

	public String getAskedAgo() {
		return askedAgo;
	}

	public void setAskedAgo(String askedAgo) {
		this.askedAgo = askedAgo;
	}

	public String getAskedBy() {
		return askedBy;
	}

	public void setAskedBy(String askedBy) {
		this.askedBy = askedBy;
	}

	public Set<String> getUserQuestionTags() {
		return userQuestionTags;
	}

	public void setUserQuestionTags(Set<String> userQuestionTags) {
		this.userQuestionTags = userQuestionTags;
	}

	public List<UserAnswer> getUserAnswerGiven() {
		return userAnswerGiven;
	}

	public void setUserAnswerGiven(List<UserAnswer> userAnswerGiven) {
		this.userAnswerGiven = userAnswerGiven;
	}

	public List<QuestionComment> getQuestionComments() {
		return questionComments;
	}

	public void setQuestionComments(List<QuestionComment> questionComments) {
		this.questionComments = questionComments;
	}

	public static List<AskQuestion> convertDtoToModelList(
			List<UserQuestionDTO> userQuestionDTOs) {
		List<AskQuestion> askQuestions = new ArrayList<AskQuestion>();
		for (UserQuestionDTO userQuestionDTO : userQuestionDTOs) {
			AskQuestion askQuestion = new AskQuestion();
			askQuestion.setUserQuestionId(userQuestionDTO.getUserQuestionId());
			askQuestion.setQuestion_title(userQuestionDTO.getQuestion_title());
			askQuestion.setQuestion_desc(userQuestionDTO.getQuestion_desc());
			askQuestion.setAskedAgo(getAskedQuestionAgo(userQuestionDTO
					.getCreated_Date()));
			Set<UserQuestionTagDTO> uTagDTOs = userQuestionDTO
					.getUserQuestionTags();
			Set<String> tagsString = new HashSet<String>();
			for (UserQuestionTagDTO userQuestionTagDTO : uTagDTOs) {
				tagsString.add(userQuestionTagDTO.getQuestionTag());
			}
			askQuestion.setUserQuestionTags(tagsString);
			askQuestion.setAskedBy(" "
					+ userQuestionDTO.getUser().getFirstName());
			askQuestions.add(askQuestion);
		}
		return askQuestions;
	}

	/*
	 * public static void main(){ SimpleDateFormat myFormat = new
	 * SimpleDateFormat("dd MM yyyy"); String inputString1 = "23 01 1997";
	 * String inputString2 = "27 04 1997";
	 * 
	 * try { Date date1 = myFormat.parse(inputString1); Date date2 =
	 * myFormat.parse(inputString2); long diff = date2.getTime() -
	 * date1.getTime(); System.out.println ("Days: " +
	 * TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)); } catch
	 * (ParseException e) { e.printStackTrace(); } }
	 */

	public static String getAskedQuestionAgo(Date createdDate) {
		long diff = new Date().getTime() - createdDate.getTime();
		return friendlyTimeDiff(diff);
	}

	static String friendlyTimeDiff(long timeDifferenceMilliseconds) {
		long diffSeconds = timeDifferenceMilliseconds / 1000;
		long diffMinutes = timeDifferenceMilliseconds / (60 * 1000);
		long diffHours = timeDifferenceMilliseconds / (60 * 60 * 1000);
		long diffDays = timeDifferenceMilliseconds / (60 * 60 * 1000 * 24);
		long diffWeeks = timeDifferenceMilliseconds / (60 * 60 * 1000 * 24 * 7);
		long diffMonths = (long) (timeDifferenceMilliseconds / (60 * 60 * 1000 * 24 * 30.41666666));
		long diffYears = timeDifferenceMilliseconds
				/ ((long) 60 * 60 * 1000 * 24 * 365);

		if (diffSeconds < 1) {
			return "less than a second";
		} else if (diffMinutes < 1) {
			return "Question asked " + diffSeconds + " seconds";
		} else if (diffHours < 1) {
			return "Question asked " + diffMinutes + " minutes";
		} else if (diffDays < 1) {
			return "Question asked " + diffHours + " hours";
		} else if (diffWeeks < 1) {
			return "Question asked " + diffDays + " days";
		} else if (diffMonths < 1) {
			return "Question asked " + diffWeeks + " weeks";
		} else if (diffYears < 1) {
			return "Question asked " + diffMonths + " months";
		} else {
			return "Question asked " + diffYears + " years";
		}
	}

	public static User convertToModel(UserDTO user) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(user, User.class);
	}

	public static AskQuestion convertDtoToModel(UserQuestionDTO userQuestionDTO) {
		AskQuestion askQuestion = new AskQuestion();
		askQuestion.setUserQuestionId(userQuestionDTO.getUserQuestionId());
		askQuestion.setQuestion_title(userQuestionDTO.getQuestion_title());
		askQuestion.setQuestion_desc(userQuestionDTO.getQuestion_desc());
		askQuestion.setAskedAgo(getAskedQuestionAgo(userQuestionDTO
				.getCreated_Date()));
		Set<UserQuestionTagDTO> uTagDTOs = userQuestionDTO
				.getUserQuestionTags();
		Set<String> tagsString = new HashSet<String>();
		for (UserQuestionTagDTO userQuestionTagDTO : uTagDTOs) {
			tagsString.add(userQuestionTagDTO.getQuestionTag());
		}
		askQuestion.setUserQuestionTags(tagsString);
		List<UserAnswerDTO> userAnswerDTOs = userQuestionDTO.getUserAnswers();
		if (userAnswerDTOs != null && !userAnswerDTOs.isEmpty()) {
			List<UserAnswer> userAnswers = new ArrayList<UserAnswer>();
			for (UserAnswerDTO userAnswerDTO : userAnswerDTOs) {
				UserAnswer userAnswer = new UserAnswer();
				userAnswer.setUserAnswerId(userAnswerDTO.getUserAnswerId());
				userAnswer.setGivenAnswer(userAnswerDTO.getGivenAnswer());
				userAnswer.setGivenBy(userAnswerDTO.getUser().getFirstName());
				userAnswer.setAnsweredAgo(getAnswergivenAgo(userAnswerDTO
						.getCreatedDate()));
				
				List<AnswerCommentDTO> answerCommentDTOs = userAnswerDTO.getAnswerComments();
				if(answerCommentDTOs != null && !answerCommentDTOs.isEmpty()){
					List<AnswerComment> answerComments = new ArrayList<AnswerComment>();
					for (AnswerCommentDTO answerCommentDTO : answerCommentDTOs) {
						AnswerComment answerComment = new AnswerComment();
						answerComment.setAnswerCommentId(answerCommentDTO.getAnswerCommentId());
						answerComment.setAnswerComment(answerCommentDTO.getAnswerComment());
						answerComment.setCreated_Date(DateFormat.getDateTimeInstance(
						DateFormat.LONG, DateFormat.LONG).format(
						answerCommentDTO.getCreatedDate()));
						answerComment.setGivenBy(answerCommentDTO.getUser().getFirstName());
						answerComments.add(answerComment);
					}
					userAnswer.setAnswerComments(answerComments);
				}
				userAnswers.add(userAnswer);
			}
			askQuestion.setUserAnswerGiven(userAnswers);
		}

		List<QuestionCommentDTO> questionCommentDTOs = userQuestionDTO
				.getQuestionComments();
		if (questionCommentDTOs != null && !questionCommentDTOs.isEmpty()) {
			List<QuestionComment> questionComments = new ArrayList<QuestionComment>();
			for (QuestionCommentDTO questionCommentDTO : questionCommentDTOs) {
				QuestionComment questionComment = new QuestionComment();
				questionComment.setQuestionId(questionCommentDTO
						.getUserQuestionCommentId());
				questionComment.setQuestionComment(questionCommentDTO
						.getQuestionComment());
				questionComment.setGivenBy(questionCommentDTO.getUser()
						.getFirstName());
				questionComment.setCreated_Date(DateFormat.getDateTimeInstance(
						DateFormat.LONG, DateFormat.LONG).format(
						questionCommentDTO.getCreatedDate()));
				questionComments.add(questionComment);
			}
			askQuestion.setQuestionComments(questionComments);
		}
		askQuestion.setAskedBy(" " + userQuestionDTO.getUser().getFirstName());
		return askQuestion;
	}

	public static String getAnswergivenAgo(Date createdDate) {
		long diff = new Date().getTime() - createdDate.getTime();
		return friendlyAnswerTimeDiff(diff);
	}

	static String friendlyAnswerTimeDiff(long timeDifferenceMilliseconds) {
		long diffSeconds = timeDifferenceMilliseconds / 1000;
		long diffMinutes = timeDifferenceMilliseconds / (60 * 1000);
		long diffHours = timeDifferenceMilliseconds / (60 * 60 * 1000);
		long diffDays = timeDifferenceMilliseconds / (60 * 60 * 1000 * 24);
		long diffWeeks = timeDifferenceMilliseconds / (60 * 60 * 1000 * 24 * 7);
		long diffMonths = (long) (timeDifferenceMilliseconds / (60 * 60 * 1000 * 24 * 30.41666666));
		long diffYears = timeDifferenceMilliseconds
				/ ((long) 60 * 60 * 1000 * 24 * 365);

		if (diffSeconds < 1) {
			return "less than a second";
		} else if (diffMinutes < 1) {
			return "Answer given " + diffSeconds + " seconds";
		} else if (diffHours < 1) {
			return "Answer given " + diffMinutes + " minutes";
		} else if (diffDays < 1) {
			return "Answer given " + diffHours + " hours";
		} else if (diffWeeks < 1) {
			return "Answer given " + diffDays + " days";
		} else if (diffMonths < 1) {
			return "Answer given " + diffWeeks + " weeks";
		} else if (diffYears < 1) {
			return "Answer given " + diffMonths + " months";
		} else {
			return "Answer given " + diffYears + " years";
		}
	}
}
