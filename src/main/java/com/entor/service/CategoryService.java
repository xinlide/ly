package com.entor.service;

import java.util.List;

import com.entor.entity.Category;
import com.entor.entity.User;

public interface CategoryService extends BaseService<Category>{

	public List<Category> queryAll();
}
