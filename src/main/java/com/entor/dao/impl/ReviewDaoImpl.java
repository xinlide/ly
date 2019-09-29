package com.entor.dao.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.ReviewDao;
import com.entor.entity.Review;
@Repository("ReviewDao")
public class ReviewDaoImpl extends BaseDaoImpl<Review> implements ReviewDao{

	private final String namespace = "Review";

	@Override
	public List<Review> queryByPid(int pid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(namespace+".queryByPid",pid);
	}

	@Override
	public int getTotalsByPid(int pid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(namespace+".getTotalsByPid",pid);
	}

	

	

}
