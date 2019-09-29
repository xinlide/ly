package com.entor.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.ProductImageDao;
import com.entor.dao.UserDao;
import com.entor.entity.Productimage;
import com.entor.entity.User;
@Repository("productImageDao")
public class ProductImageDaoImpl extends BaseDaoImpl<Productimage> implements ProductImageDao{

	private final String namespace = "ProductImage";

	@Override
	public Productimage queryByPid(int pid) {
		return getSqlSession().selectOne(namespace+".queryByPid",pid);
	}

	@Override
	public List<Productimage> queryTypeSingle(int pid) {
		return getSqlSession().selectList(namespace+".queryTypeSingle",pid);
	}

	@Override
	public List<Productimage> queryTypeDetail(int pid) {
		return getSqlSession().selectList(namespace+".queryTypeDetail",pid);
	}

}
