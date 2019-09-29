package com.entor.serivce.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.entor.dao.PropertyDao;
import com.entor.dao.PropertyValueDao;
import com.entor.dao.ProductImageDao;
import com.entor.dao.UserDao;
import com.entor.entity.Property;
import com.entor.entity.Propertyvalue;
import com.entor.entity.User;
import com.entor.service.PropertyService;
import com.entor.service.PropertyValueService;
@Repository("propertyValueService")
public class PropertyValueServiceImpl extends BaseServiceImpl<Propertyvalue> implements PropertyValueService{

	
	@Resource
	private PropertyValueDao propertyValueDao;

	@Override
	public List<Propertyvalue> queryByPid(int pid) {
		
		return propertyValueDao.queryByPid(pid);
	}
	

}
