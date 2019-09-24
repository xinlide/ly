package com.entor.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.UserDao;
import com.entor.entity.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	private final String namespace = "User";

	@Override
	public User login(String name, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", name);
		map.put("password", password);
		return getSqlSession().selectOne(namespace+".login",map);
	}

}
