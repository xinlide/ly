package com.entor.dao;

import java.util.List;

import com.entor.entity.Category;
import com.entor.entity.User;

public interface CategoryDao extends BaseDao<Category>{

	public List<Category> queryAll();
}
