package com.entor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.dao.UserDao;
import com.entor.entity.Category;
import com.entor.entity.User;
import com.entor.service.CategoryService;
import com.entor.service.UserService;

@Controller
public class TestController {

	@Resource
	private CategoryService categoryService;
	@RequestMapping("index")
	private String queryByPage(Map<String, Object> map) {
		List<Category> clist = categoryService.queryByPage(Category.class, 1, 5);
		map.put("cs", clist);
		map.put("cs", clist);
		return "include/fore/home/homePage";
	}
	
}
