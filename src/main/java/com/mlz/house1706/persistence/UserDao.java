package com.mlz.house1706.persistence;

import com.mlz.house1706.domain.User;

public interface UserDao extends BaseDao<User, Integer> {
	User findByUsername(String username);
}
