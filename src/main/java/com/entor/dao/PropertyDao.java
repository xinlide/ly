package com.entor.dao;

import java.util.List;
import java.util.Map;

import com.entor.entity.Property;
import com.entor.entity.User;

public interface PropertyDao extends BaseDao<Property>{

	public List<Property> queryPageByCid(Class<?> cls,Map<String, Integer> map);
}
