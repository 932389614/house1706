package com.mlz.house1706.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mlz.house1706.domain.User;
import com.mlz.house1706.persistence.UserDao;

@Repository
public class UserDaoImpl extends BaseDaoAdapter<User, Integer> implements UserDao {

	@Override
	public User findByUsername(String username) {
		List<User> users = sessionFactory.getCurrentSession()
				.createQuery("from User as u where u.username=:username", User.class).setParameter("username", username)
				.getResultList();
		return users.size() == 1 ? users.get(0) : null;
	}

}
