package com.entor.service;

import java.util.List;

import com.entor.entity.Property;
import com.entor.entity.Propertyvalue;
import com.entor.entity.User;

public interface PropertyValueService extends BaseService<Propertyvalue>{

	public List<Propertyvalue> queryByPid(int pid);
}
