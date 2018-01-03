package com.app.challenge.java.DAO;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.cfg.CreateKeySecondPass;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.app.challenge.java.DTO.PasswordResetTokenDTO;
import com.app.challenge.java.DTO.UserDTO;
import com.app.challenge.java.controller.ChallangeController;



@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, UserDTO> implements UserDao {

	private final static Logger logger = Logger
			.getLogger(UserDaoImpl.class);
	
	public UserDTO findById(int id) {
		UserDTO user = getByKey(id);
		if(user!=null){
			Hibernate.initialize(user.getUserProfiles());
		}
		return user;
	}

	public UserDTO findBySSO(String sso) {
		logger.info("SSO : {}"+ sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		UserDTO user = (UserDTO)crit.uniqueResult();
		if(user!=null){
			Hibernate.initialize(user.getUserProfiles());
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<UserDTO> findAllUsers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<UserDTO> users = (List<UserDTO>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return users;
	}

	public void save(UserDTO user) {
		persist(user);
	}

	public void deleteBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		UserDTO user = (UserDTO)crit.uniqueResult();
		delete(user);
	}
	
	@Override
	public Integer setUserSignUp(UserDTO userDTO) {
		userDTO.setCreatedDate(new Date());
		userDTO.setModifiedDate(new Date());
		this.getSession().saveOrUpdate(userDTO);
		Integer identification = 1;
		logger.info("user sign up"+identification);
		return identification;
	}

	@Override
	public UserDTO findUserByEmail(String userEmail) {
		UserDTO user = null;
		try{
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("email", userEmail));
		user = (UserDTO)criteria.uniqueResult();
		if(user!=null){
			Hibernate.initialize(user.getUserProfiles());
		}
		}catch(Exception exception){
			System.out.println(exception);
		}
		return user;
	}

}
