package com.entor.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.entor.dao.BaseDao;
import com.entor.dao.ProductDao;
import com.entor.dao.ProductImageDao;
import com.entor.dao.UserDao;
import com.entor.entity.Product;
import com.entor.entity.User;
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{

	private final String namespace = "Product";

	@Override
	public List<Product> queryPageByCid(Class<?> cls, int cid, int currentPage, int pageSize) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", (currentPage-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("cid", cid);
		return getSqlSession().selectList(cls.getSimpleName()+".queryPageByCid",map);
	}

	@Override
	public int getTotalsByCid(Class<?> cls,int cid) {
		
		return getSqlSession().selectOne(cls.getSimpleName()+".getTotalsByCid",cid);
	}

	@Override
	public Product queryByPid(Class<?> cls, int pid) {
		return getSqlSession().selectOne(cls.getSimpleName()+".queryByPid",pid);
	}

	@Override
	public List<Product> queryByCid(int cid) {
		return getSqlSession().selectList(namespace+".queryByCid",cid);
	}

}
