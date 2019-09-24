package com.entor.dao.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.PropertyDao;
import com.entor.entity.Property;
@Repository("propertyDao")
public class PropertyDaoImpl extends BaseDaoImpl<Property> implements PropertyDao{

	private final String namespace = "Property";

	@Override
	public List<Property> queryPageByCid(Class<?> cls,Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(namespace+".queryPageByCid",map);
	}

}
