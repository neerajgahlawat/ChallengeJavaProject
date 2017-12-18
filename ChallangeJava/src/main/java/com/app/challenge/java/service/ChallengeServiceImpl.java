package com.app.challenge.java.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.omg.PortableServer.POAManagerPackage.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.challenge.java.DAO.ChallengeDAO;
import com.app.challenge.java.DTO.NotifyDTO;
import com.app.challenge.java.DTO.UserDTO;
import com.app.challenge.java.DTO.UserProfileDTO;
import com.app.challenge.java.model.Notify;
import com.app.challenge.java.model.SignUp;
import com.app.challenge.java.util.UserProfileType;

@Service("challengeService")
public class ChallengeServiceImpl implements ChallengeService {

	private final static Logger logger = Logger
			.getLogger(ChallengeServiceImpl.class);

	@Autowired
	ChallengeDAO challengeDAO;

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

	

}
