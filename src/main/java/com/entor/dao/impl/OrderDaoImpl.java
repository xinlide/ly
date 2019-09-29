package com.entor.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.CategoryDao;
import com.entor.dao.OrderDao;
import com.entor.dao.ProductDao;
import com.entor.dao.ProductImageDao;
import com.entor.dao.UserDao;
import com.entor.entity.Order_;
import com.entor.entity.User;
@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order_> implements OrderDao{

	private final String namespace = "Order_";

}
