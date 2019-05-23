package com.app.challenge.java.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.challenge.java.model.AnswerComment;
import com.app.challenge.java.model.AskQuestion;
import com.app.challenge.java.model.QuestionComment;
import com.app.challenge.java.model.UserAnswer;
import com.app.challenge.java.service.ChallengeService;

@Controller
@SessionAttributes("user_question")
public class QuestionAnswerController {

	private final static Logger logger = Logger
			.getLogger(QuestionAnswerController.class);

	@Autowired
	@Qualifier("challengeService")
	ChallengeService challengeService;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	@RequestMapping(value = "/user/askQuestion", method = RequestMethod.POST)
	public String askQuestion(
			@ModelAttribute("askQuestion") AskQuestion askQuestion, Model model) {
		logger.info("-------------Ask question Started-------------");
		try {
			challengeService.askQuestion(askQuestion);
			model.addAttribute("USER_ASK_QUESTIONS",
					challengeService.getAskedQuestionList());
			model.addAttribute("askQuestion", new AskQuestion());
		} catch (Exception exception) {
			logger.error("Error In Ask question", exception);
		}
		logger.info("-------------Ask question End-------------");
		return "askQuestion";
	}

	@RequestMapping(value = "/user/question_{id}", method = RequestMethod.GET)
	public String getQuestionById(@PathVariable String id, Model model,
			HttpSession session) {
		logger.info("-------------get Ask question By Id Started-------------");
		try {
			AskQuestion askQuestion = challengeService.getQuestionById(id);
			model.addAttribute("user_question", askQuestion);
			session.setAttribute("userQuestionDetail", askQuestion);
			model.addAttribute("userAnswer", new UserAnswer());
			model.addAttribute("user", getPrincipal());
			model.addAttribute("questionComment", new QuestionComment());
			model.addAttribute("answerComment", new AnswerComment());
		} catch (Exception exception) {
			logger.error("Error get Ask question By Id", exception);
		}
		logger.info("-------------get Ask question By Id End-------------");
		return "questionDetail";
	}

	@RequestMapping(value = "/user/login/question", method = RequestMethod.GET)
	public String getLoginForAnswer(Model model, HttpSession session) {
		logger.info("-------------get Ask question By Id Started-------------");
		try {
			model.addAttribute("user", getPrincipal());
			AskQuestion askQuestion = (AskQuestion) session
					.getAttribute("userQuestionDetail");
			model.addAttribute("user_question", askQuestion);
			model.addAttribute("userAnswer", new UserAnswer());
			model.addAttribute("questionComment", new QuestionComment());
			model.addAttribute("answerComment", new AnswerComment());
		} catch (Exception exception) {
			logger.error("Error get Ask question By Id", exception);
		}
		logger.info("-------------get Ask question By Id End-------------");
		return "questionDetail";
	}

	@RequestMapping(value = "/user/answer", method = RequestMethod.POST)
    public String setUserAnswer(@ModelAttribute("userAnswer") UserAnswer userAnswer, Model model){
		String res = null; 
		logger.info("-------------insert user answer Started-------------");
		try{
			 String loginUser= getPrincipal();
			if(loginUser != null && !loginUser.equals("anonymousUser")){
				challengeService.insertUserAnswer(userAnswer);
				res = "redirect:/user/question_"+userAnswer.getUserQuestionId();
			}else{
				model.addAttribute("USER_NOT_LOGIN", "To answer a question, you must either sign up for an account or login.");
				model.addAttribute("questionComment", new QuestionComment());
				res = "questionDetail";
			}
		}catch(Exception exception){
			logger.error("Error insert user answer", exception);
		}
		logger.info("-------------insert user answer End-------------");
		return res;
	}
	
	@RequestMapping(value = "/user/question/comment", method = RequestMethod.POST)
	public String setUserQuestionComment(@ModelAttribute("questionComment") QuestionComment questionComment, Model model){
		String res = null; 
		logger.info("-------------User Question Comment Started-------------");
		try{
			 String loginUser= getPrincipal();
			if(loginUser != null && !loginUser.equals("anonymousUser")){
				challengeService.setUserQuestionComment(questionComment);
				res = "redirect:/user/question_"+questionComment.getQuestionId();
			}else{
				model.addAttribute("USER_COMMENT_NOT_LOGIN", "To comment , you must either sign up for an account or login.");
				model.addAttribute("userAnswer", new UserAnswer());
				model.addAttribute("questionComment", new QuestionComment());
				model.addAttribute("answerComment", new AnswerComment());
				res = "questionDetail";
			}
		}catch(Exception exception){
			logger.error("Error User Question Comment", exception);
		}
		logger.info("-------------User Question Comment End-------------");
		return res;
	}
	
	@RequestMapping(value = "/user/answer/comment", method = RequestMethod.POST)
	public String setUserAnswerComment(@ModelAttribute("answerComment") AnswerComment answerComment, Model model){
		String res = null; 
		logger.info("-------------User Answer Comment Started-------------");
		try{
			 String loginUser= getPrincipal();
			if(loginUser != null && !loginUser.equals("anonymousUser")){
				challengeService.setUserAnswerComment(answerComment);
				res = "redirect:/user/question_"+answerComment.getQuestionId();
			}else{
				model.addAttribute("USER_COMMENT_NOT_LOGIN", "To comment, you must either sign up for an account or login.");
				model.addAttribute("userAnswer", new UserAnswer());
				model.addAttribute("questionComment", new QuestionComment());
				model.addAttribute("answerComment", new AnswerComment());
				res = "questionDetail";
			}
		}catch(Exception exception){
			logger.error("Error User Answer Comment", exception);
		}
		logger.info("------------- User Answer Comment End-------------");
		return res;
	}
	
	

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	/**
	 * This method returns true if users is already authenticated [logged-in],
	 * else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder
				.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}
}
