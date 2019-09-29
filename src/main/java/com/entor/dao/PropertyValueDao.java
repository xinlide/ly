package com.entor.dao;

import java.util.List;
import java.util.Map;

import com.entor.entity.Propertyvalue;

public interface PropertyValueDao extends BaseDao<Propertyvalue>{

	public List<Propertyvalue> queryByPid(int pid);
}
