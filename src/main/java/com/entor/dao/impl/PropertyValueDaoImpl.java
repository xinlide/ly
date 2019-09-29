package com.entor.dao.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.PropertyDao;
import com.entor.dao.PropertyValueDao;
import com.entor.entity.Property;
import com.entor.entity.Propertyvalue;
@Repository("propertyValueDao")
public class PropertyValueDaoImpl extends BaseDaoImpl<Propertyvalue> implements PropertyValueDao{

	private final String namespace = "Propertyvalue";

	@Override
	public List<Propertyvalue> queryByPid(int pid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(namespace+".queryByPid",pid);
	}

	

}
