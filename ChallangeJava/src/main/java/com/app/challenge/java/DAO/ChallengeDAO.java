package com.app.challenge.java.DAO;

import java.util.List;

import com.app.challenge.java.DTO.NotifyDTO;


public interface ChallengeDAO {

	public void setNotifyMe(NotifyDTO notifyDTO);
	
	public List<NotifyDTO> getNotifyMe(NotifyDTO notifyDTO);
}
