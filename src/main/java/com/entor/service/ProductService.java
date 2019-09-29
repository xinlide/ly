package com.entor.service;

import java.util.List;

import com.entor.entity.Product;
import com.entor.entity.User;

public interface ProductService extends BaseService<Product>{

	public List<Product> queryPageByCid(Class<?> cls,int cid, int currentPage, int pageSize);
	
	public int getTotalsByCid(Class<?> cls,int cid);
	
	public Product queryByPid(Class<?> cls,int pid);
	
	public List<Product> queryByCid(int cid);
}
