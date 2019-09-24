package com.entor.service;

import java.util.List;

import com.entor.entity.Property;
import com.entor.entity.User;

public interface PropertyService extends BaseService<Property>{

	public List<Property> queryPageByCid(int cid,Class<?> cls,int currentPage,int pageSize);
}
