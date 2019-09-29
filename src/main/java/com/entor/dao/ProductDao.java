package com.entor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.entor.entity.Product;
import com.entor.entity.User;

public interface ProductDao extends BaseDao<Product>{

	public List<Product> queryPageByCid(Class<?> cls,int cid, int currentPage, int pageSize);
	
	public int getTotalsByCid(Class<?> cls,int cid);
	
	public Product queryByPid(Class<?> cls,int pid);
	
	public List<Product> queryByCid(int cid);
}
