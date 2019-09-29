package com.entor.serivce.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.entor.dao.PropertyDao;
import com.entor.dao.PropertyValueDao;
import com.entor.dao.ReviewDao;
import com.entor.dao.ProductImageDao;
import com.entor.dao.UserDao;
import com.entor.entity.Property;
import com.entor.entity.Propertyvalue;
import com.entor.entity.Review;
import com.entor.entity.User;
import com.entor.service.PropertyService;
import com.entor.service.PropertyValueService;
import com.entor.service.ReviewService;
@Repository("review")
public class ReviewServiceImpl extends BaseServiceImpl<Review> implements ReviewService{

	
	@Resource
	private ReviewDao reviewDao;

	@Override
	public List<Review> queryByPid(int pid) {
		// TODO Auto-generated method stub
		return reviewDao.queryByPid(pid);
	}

	@Override
	public int getTotalsByPid(int pid) {
		// TODO Auto-generated method stub
		return reviewDao.getTotalsByPid(pid);
	}


}
