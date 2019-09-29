package com.entor.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.OrderitemDao;
import com.entor.dao.UserDao;
import com.entor.entity.Orderitem;
import com.entor.entity.User;
@Repository("OrderitemDao")
public class OrderitemDaoImpl extends BaseDaoImpl<Orderitem> implements OrderitemDao{

	private final String namespace = "Orderitem";

	@Override
	public List<Orderitem> queryByUid(int uid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(namespace+".queryByUid",uid);
	}
//-----------------------------------
	@Override
	public int getSumNumberByPid(int pid) {
		// TODO Auto-generated method stub
		int i = 0;
		String str = getSqlSession().selectOne(namespace+".getSumNumberByPid",pid);
		if(str == null) {
			return i;
		}
		return Integer.parseInt(str);
	}
	@Override
	public Orderitem queryByPidAndUid(int pid, int uid) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("pid", String.valueOf(pid));
		map.put("uid", String.valueOf(uid));
		return getSqlSession().selectOne(namespace+".queryByPidAndUid",map);
	}

	

}
