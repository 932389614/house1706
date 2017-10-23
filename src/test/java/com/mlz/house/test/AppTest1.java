package com.mlz.house.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mlz.house1706.domain.User;
import com.mlz.house1706.persistence.House_TypeDao;
import com.mlz.house1706.persistence.UserDao;
import com.mlz.house1706.persistence.impl.House_TypeDaoImpl;
import com.mlz.house1706.persistence.impl.UserDaoImpl;
import com.mlz.house1706.service.LocationService;
import com.mlz.house1706.service.UserService;
import com.mlz.house1706.service.impl.LocationServiceImpl;
import com.mlz.house1706.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class AppTest1 {
	@Autowired
	UserService userService;

	@Test
	public void testLogin() {
		User user = new User("user12", "user1", "������ë", "12345678909", false);
		//System.out.println(userService.login(user));
	}

	@Test
	public void testRegister() {
		
	}

}
