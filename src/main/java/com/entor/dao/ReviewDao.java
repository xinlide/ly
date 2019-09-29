package com.entor.dao;

import java.util.List;
import java.util.Map;

import com.entor.entity.Propertyvalue;
import com.entor.entity.Review;

public interface ReviewDao extends BaseDao<Review>{

	public List<Review> queryByPid(int pid);
	
	public int getTotalsByPid(int pid);
}
