package com.mlz.house1706.service;

import com.mlz.house1706.domain.User;
import com.mlz.house1706.dto.UserLoginDto;

public interface UserService {
	boolean login(UserLoginDto user);

	boolean register(User user);
	
	boolean checkUnique(String username);
}
