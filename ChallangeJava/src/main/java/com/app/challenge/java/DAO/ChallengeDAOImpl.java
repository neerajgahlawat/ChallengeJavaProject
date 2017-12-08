package com.app.challenge.java.DAO;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.app.challenge.java.DTO.NotifyDTO;

@Repository("challengeDAO")
public class ChallengeDAOImpl extends AbstractDao implements ChallengeDAO {

	private final static Logger logger = Logger
			.getLogger(ChallengeDAOImpl.class);

	@Override
	public void setNotifyMe(NotifyDTO notifyDTO) {
		notifyDTO.setCreatedDate(new Date());
		this.getSession().persist(notifyDTO);
		logger.info("primary key of notify ==");
	}

	@Override
	public List<NotifyDTO> getNotifyMe(NotifyDTO notifyDTO) {
		String strQuery = "from NotifyDTO notify where notify.email = :email or   notify.phone = :phone";
		Query query  = this.getSession().createQuery(strQuery);
		query.setParameter("email", notifyDTO.getEmail());
		query.setParameter("phone", notifyDTO.getPhone());
		return query.list();
		
	}
	
	

}
