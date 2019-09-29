package com.entor.serivce.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.entor.dao.ProductImageDao;
import com.entor.dao.UserDao;
import com.entor.entity.Productimage;
import com.entor.entity.User;
import com.entor.service.ProductImageService;
@Repository("propertyImageService")
public class ProductImageServiceImpl extends BaseServiceImpl<Productimage> implements ProductImageService{
	
	@Resource
	private ProductImageDao productImageDao;
	@Override
	public Productimage queryByPid(int pid) {
		// TODO Auto-generated method stub
		return productImageDao.queryByPid(pid);
	}
	@Override
	public List<Productimage> queryTypeSingle(int pid) {
		return productImageDao.queryTypeSingle(pid);
	}
	@Override
	public List<Productimage> queryTypeDetail(int pid) {
		return productImageDao.queryTypeDetail(pid);
	}

	

}
