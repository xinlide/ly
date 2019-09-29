package com.entor.dao;

import java.util.List;

import com.entor.entity.Orderitem;

public interface OrderitemDao extends BaseDao<Orderitem>{

	public List<Orderitem> queryByUid(int uid);
	
	public int getSumNumberByPid(int pid);
	
	public Orderitem queryByPidAndUid(int pid,int uid);
}
