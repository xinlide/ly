package com.entor.service;

import java.util.List;

import com.entor.entity.Orderitem;

public interface OrderitemService extends BaseService<Orderitem> {

	public List<Orderitem> queryByUid(int uid);
	
	public int getSumNumberByPid(int pid);
	
	public Orderitem queryByPidAndUid(int pid,int uid);
}
