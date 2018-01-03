package com.app.challenge.java.service;

import java.util.List;

import com.app.challenge.java.model.AnswerComment;
import com.app.challenge.java.model.AskQuestion;
import com.app.challenge.java.model.Notify;
import com.app.challenge.java.model.QuestionComment;
import com.app.challenge.java.model.SignUp;
import com.app.challenge.java.model.UserAnswer;

public interface ChallengeService {

	public String setNotifyMe(Notify notify);

	public void askQuestion(AskQuestion askQuestion);

	public List<AskQuestion> getAskedQuestionList();

	public List<AskQuestion> getAllAskedQuestionList();

	public AskQuestion getQuestionById(String questionId);

	public void insertUserAnswer(UserAnswer userAnswer);

	public void setUserQuestionComment(QuestionComment questionComment);

	public void setUserAnswerComment(AnswerComment answerComment);
	
}
