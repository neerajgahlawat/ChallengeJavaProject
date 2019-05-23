package com.app.challenge.java.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.app.challenge.java.DTO.UserProfileDTO;

@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfileDTO>
		implements UserProfileDao {

	public UserProfileDTO findById(int id) {
		return getByKey(id);
	}

	public UserProfileDTO findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		return (UserProfileDTO) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<UserProfileDTO> findAll() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("type"));
		return (List<UserProfileDTO>) crit.list();
	}

}
