/*package com.entor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.User;
import com.entor.service.UserService;

@Controller
public class TestUserController {

	@Resource
	private UserService userService;
	@RequestMapping("/addForm")
	public String add() {
		return "add";
	}
	@RequestMapping("/add")
	public String add(User user) {
		userService.add(user);
		return "redirect:loginForm";
	}
	@RequestMapping("/loginForm")
	public String login() {
		return "login";
	}
	@RequestMapping("loginOut")
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}
	@RequestMapping("/login")
	public String login(User user,HttpSession session) {
		user = userService.login(user.getName(), user.getPassword());
		if(user!=null) {
			//保存登录信息到会话对象中
			session.setAttribute("u", user);
			return "redirect:list/1";
		}else {
			return "redirect:loginForm";
		}
	}
	@RequestMapping("/queryById/{currentPage}/{id}")
	public String queryById(@PathVariable String currentPage,@PathVariable int id,Map<String, Object> map) {
		User user = userService.queryById(User.class, id);
		map.put("currentPage", currentPage);
		map.put("user", user);
		return "update";
	}
	@RequestMapping("/deleteById/{currentPage}/{id}")
	public String deleteById(@PathVariable String currentPage,@PathVariable int id,Map<String, Object> map) {
		userService.deleteById(User.class, id);
		return "redirect:/list/"+currentPage;
	}
	@RequestMapping("/update")
	public String update(User user,String currentPage) {
		userService.update(user);
		return "redirect:/list/"+currentPage;
	}
	@RequestMapping("/list/{currenPage}")
	public String list(@PathVariable String currenPage,Map<String, Object> map) {
		int sp = 1;
		int pageSize = 20;
		int totals = userService.getTotals(User.class);
		int pageCounts = totals/pageSize;
		if(totals%pageSize!=0) {
			pageCounts++;
		}
		try {
			sp = Integer.parseInt(currenPage);
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
		map.put("totals", totals);
		map.put("sp", sp);
		map.put("pageCounts", pageCounts);
		map.put("list", list);
		return "list";
	}
}
*/