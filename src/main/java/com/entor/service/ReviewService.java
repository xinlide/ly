package com.entor.service;

import java.util.List;

import com.entor.entity.Property;
import com.entor.entity.Propertyvalue;
import com.entor.entity.Review;
import com.entor.entity.User;

public interface ReviewService extends BaseService<Review>{

	public List<Review> queryByPid(int pid);
	
	public int getTotalsByPid(int pid);
}
