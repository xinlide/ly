package com.entor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.dao.UserDao;
import com.entor.entity.User;
import com.entor.service.UserService;

@Controller
public class UserController {

	@Resource
	private UserService userService;
	@RequestMapping("user_queryByPage")
	private String queryByPage() {
		return "redirect:/listUser/1";
	}
	@RequestMapping("/listUser/{currentPage}")
	public String listUser(@PathVariable String currentPage,Map<String, Object> map) {
		int sp = 1;
		int pageSize = 5;
		int totals = userService.getTotals(User.class);
		int pageCounts = totals/pageSize;
		if(totals%pageSize!=0) {
			pageCounts++;
		}
		try {
			sp = Integer.parseInt(currentPage);
		}catch (Exception e) {
			sp = 1;
		}
		if(sp>pageCounts) {
			sp = pageCounts;
		}
		if(sp<1) {
			sp = 1;
		}
		List<User> list = userService.queryByPage(User.class, sp, pageSize);
		map.put("name", "listUser");
		map.put("totals", totals);
		map.put("sp", sp);
		map.put("pageCounts", pageCounts);
		map.put("us", list);
		return "/admin/listUser";
	}
}
