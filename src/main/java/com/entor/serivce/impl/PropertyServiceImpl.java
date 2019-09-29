package com.entor.serivce.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.entor.dao.PropertyDao;
import com.entor.dao.ProductImageDao;
import com.entor.dao.UserDao;
import com.entor.entity.Property;
import com.entor.entity.User;
import com.entor.service.PropertyService;
@Repository("propertyService")
public class PropertyServiceImpl extends BaseServiceImpl<Property> implements PropertyService{

	
	@Resource
	private PropertyDao propertyDao;
	@Override
	public List<Property> queryPageByCid(int cid,Class<?> cls,int currentPage,int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", (currentPage-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("cid", cid);
		return propertyDao.queryPageByCid(cls,map);
	}

}
