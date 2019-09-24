package com.entor.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.ProductDao;
import com.entor.dao.PropertyImageDao;
import com.entor.dao.UserDao;
import com.entor.entity.Product;
import com.entor.entity.User;
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{

	private final String namespace = "Product";

}
