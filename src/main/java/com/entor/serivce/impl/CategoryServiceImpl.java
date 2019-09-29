package com.entor.serivce.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.entor.dao.CategoryDao;
import com.entor.dao.ProductDao;
import com.entor.dao.ProductImageDao;
import com.entor.dao.UserDao;
import com.entor.entity.Category;
import com.entor.entity.User;
import com.entor.service.CategoryService;
@Repository("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService{

	@Resource
	private CategoryDao categoryDao;
	@Override
	public List<Category> queryAll() {
		// TODO Auto-generated method stub
		return categoryDao.queryAll();
	}

	

}
