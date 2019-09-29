package com.entor.serivce.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.entor.dao.ProductDao;
import com.entor.dao.ProductImageDao;
import com.entor.dao.UserDao;
import com.entor.entity.Product;
import com.entor.entity.User;
import com.entor.service.ProductService;
@Repository("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{

	@Resource
	private ProductDao productDao;

	@Override
	public List<Product> queryPageByCid(Class<?> cls, int cid, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return productDao.queryPageByCid(cls, cid, currentPage, pageSize);
	}

	@Override
	public int getTotalsByCid(Class<?> cls, int cid) {
		// TODO Auto-generated method stub
		return productDao.getTotalsByCid(cls, cid);
	}

	@Override
	public Product queryByPid(Class<?> cls, int pid) {
		
		return productDao.queryByPid(cls, pid);
	}

	@Override
	public List<Product> queryByCid(int cid) {
		
		return productDao.queryByCid(cid);
	}
	

}
