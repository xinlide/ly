package com.entor.controller.fore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.entity.User;
import com.entor.service.UserService;

@Controller
public class UserForeController {

	@Resource
	private UserService userService;
	@RequestMapping("loginPage")
	public String loginPage() {
		return "/fore/login";
	}
	
	@RequestMapping("forelogin")
	public String forelogin(HttpServletRequest request,HttpSession session,Map<String, String> map) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User user = userService.login(name, password);
		if(user!=null) {
			//保存登录信息到会话对象中
			session.setAttribute("user", user);
			return "redirect:forehome";
		}else {
			String msg = "账号或密码错误！";
			map.put("msg", msg);
			return "/fore/login";
		}
	}
	
	@RequestMapping("forecheckLogin")
	@ResponseBody
	public String forecheckLogin(HttpSession session,Object user,HttpServletRequest request,HttpServletResponse response) throws IOException {
		user = session.getAttribute("user");
		String s;
		if(user == null) {
			s = null;
		}else {
			s = "success";
		}
		return s;
	}
	
	@RequestMapping("forelogout")
	public String forelogout(HttpSession session) {
		session.removeAttribute("user");
		return "/fore/login";
	}
}
