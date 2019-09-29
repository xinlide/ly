package com.entor.dao;

import java.util.List;

import com.entor.entity.Productimage;
import com.entor.entity.User;

public interface ProductImageDao extends BaseDao<Productimage>{
	public Productimage queryByPid(int pid);
	
	public List<Productimage> queryTypeSingle(int pid);
	
	public List<Productimage> queryTypeDetail(int pid);
}
