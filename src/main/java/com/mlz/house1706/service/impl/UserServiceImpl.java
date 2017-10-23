package com.mlz.house1706.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mlz.house1706.domain.Login_Log;
import com.mlz.house1706.domain.User;
import com.mlz.house1706.dto.UserLoginDto;
import com.mlz.house1706.persistence.Login_LogDao;
import com.mlz.house1706.persistence.UserDao;
import com.mlz.house1706.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private Login_LogDao login_LogDao;

	@Override
	public boolean login(UserLoginDto user) {
		User loginuser = userDao.findByUsername(user.getUsername());
		boolean islogin = false;
		if (loginuser != null) {
			islogin = user.getPassword().equals(loginuser.getPassword());
			System.out.println(islogin);
			if (islogin) {
				user.setId(loginuser.getId());
				user.setRelName(loginuser.getRealName());
				Login_Log login_Log = new Login_Log(loginuser, user.getIpAddress(), new Date());
				return login_LogDao.save(login_Log) != null && islogin;
			}
		} 
		return false;
	}

	@Override
	public boolean register(User user) {
		if (userDao.findByUsername(user.getUsername()) != null)
			return false;
		return userDao.save(user) != null;
	}

	@Override
	public boolean checkUnique(String username) {
		return userDao.findByUsername(username)==null;
	}
}
