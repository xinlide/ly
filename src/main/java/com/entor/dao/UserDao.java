package com.entor.dao;

import com.entor.entity.User;

public interface UserDao extends BaseDao<User>{

	public User login(String name,String password);
}
