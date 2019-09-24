package com.entor.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.PropertyImageDao;
import com.entor.dao.UserDao;
import com.entor.entity.Productimage;
import com.entor.entity.User;
@Repository("propertyImageDao")
public class PropertyImageDaoImpl extends BaseDaoImpl<Productimage> implements PropertyImageDao{

	private final String namespace = "PropertyImage";

}
