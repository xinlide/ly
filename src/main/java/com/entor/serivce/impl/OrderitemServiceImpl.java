package com.entor.serivce.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.OrderitemDao;
import com.entor.dao.UserDao;
import com.entor.entity.Orderitem;
import com.entor.entity.User;
import com.entor.service.OrderitemService;
import com.entor.service.UserService;

@Service("orderitemService")
public class OrderitemServiceImpl extends BaseServiceImpl<Orderitem> implements OrderitemService{

	@Resource
	private OrderitemDao orderitemDao;

	@Override
	public List<Orderitem> queryByUid(int uid) {
		// TODO Auto-generated method stub
		return orderitemDao.queryByUid(uid);
	}

	@Override
	public int getSumNumberByPid(int pid) {
		// TODO Auto-generated method stub
		return orderitemDao.getSumNumberByPid(pid);
	}

	@Override
	public Orderitem queryByPidAndUid(int pid, int uid) {
		// TODO Auto-generated method stub
		return orderitemDao.queryByPidAndUid(pid, uid);
	}
	

}
