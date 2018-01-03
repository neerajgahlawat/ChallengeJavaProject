package com.app.challenge.java.DAO;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.challenge.java.DTO.NotifyDTO;
import com.app.challenge.java.DTO.PasswordResetTokenDTO;
import com.app.challenge.java.DTO.UserQuestionTagDTO;

@Repository("challengeDAO")
public class ChallengeDAOImpl implements ChallengeDAO {
	
	@Autowired
    private SessionFactory sessionFactory;

	private final static Logger logger = Logger
			.getLogger(ChallengeDAOImpl.class);

	@Override
	public void setNotifyMe(NotifyDTO notifyDTO) {
		notifyDTO.setCreatedDate(new Date());
		Session session = sessionFactory.openSession();
		session.persist(notifyDTO);
		session.flush();
		session.clear();
		session.close();
		logger.info("primary key of notify ==");
	}

	@Override
	public List<NotifyDTO> getNotifyMe(NotifyDTO notifyDTO) {
		String strQuery = "from NotifyDTO notify where notify.email = :email or   notify.phone = :phone";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(strQuery);
		query.setParameter("email", notifyDTO.getEmail());
		query.setParameter("phone", notifyDTO.getPhone());
		session.flush();
		session.clear();
		session.close();
		List<NotifyDTO> notifyDTOs =  query.list();
		return notifyDTOs;
	}

	@Override
	public UserQuestionTagDTO findByTag(String question_tag) {
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(UserQuestionTagDTO.class);
		crit.add(Restrictions.eq("questionTag", question_tag));
		UserQuestionTagDTO userQuestionTagDTO =(UserQuestionTagDTO) crit.uniqueResult();
		session.flush();
		session.clear();
		session.close();
		return userQuestionTagDTO;
	}
	
	public List<UserQuestionTagDTO> getAllUserQuestionTags(){
		Session session = sessionFactory.openSession();
		List<UserQuestionTagDTO> userQuestionTagDTOs = session.createCriteria(UserQuestionTagDTO.class).list();
		session.flush();
		session.clear();
		session.close();
		return userQuestionTagDTOs;
	}

	@Override
	public void setResetTokenForUser(PasswordResetTokenDTO myToken) {
		try{
		Session session = sessionFactory.openSession();
		session.persist(myToken);
		session.flush();
		session.clear();
		session.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public PasswordResetTokenDTO findByToken(String token) {
		PasswordResetTokenDTO passwordResetTokenDTO =  null;
		try{
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(PasswordResetTokenDTO.class);
		crit.add(Restrictions.eq("token", token));
		passwordResetTokenDTO = (PasswordResetTokenDTO) crit
				.uniqueResult();
		session.flush();
		session.clear();
		session.close();
		}catch(Exception exception){
			System.out.println(exception);
		}
		return passwordResetTokenDTO;
	}

}
