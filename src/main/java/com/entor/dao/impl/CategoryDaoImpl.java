package com.entor.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.CategoryDao;
import com.entor.dao.ProductDao;
import com.entor.dao.ProductImageDao;
import com.entor.dao.UserDao;
import com.entor.entity.Category;
import com.entor.entity.User;
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao{

	private final String namespace = "Category";

	@Override
	public List<Category> queryAll() {
		
		return getSqlSession().selectList(namespace+".queryAll");
	}

}
