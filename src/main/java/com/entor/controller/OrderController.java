package com.entor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.dao.UserDao;
import com.entor.entity.Order_;
import com.entor.entity.User;
import com.entor.service.OrderService;
import com.entor.service.UserService;

@Controller
public class OrderController {

	@Resource
	private OrderService orderService;
	@RequestMapping("order_queryByPage")
	private String order_queryByPage() {
		return "redirect:/listOrder/1";
	}
	@RequestMapping("/listOrder/{currentPage}")
	public String listOrder(@PathVariable String currentPage,Map<String, Object> map) {
		int sp = 1;
		int pageSize = 5;
		int totals = orderService.getTotals(Order_.class);
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
		List<Order_> list = orderService.queryByPage(Order_.class, sp, pageSize);
		map.put("name", "listUser");
		map.put("totals", totals);
		map.put("sp", sp);
		map.put("pageCounts", pageCounts);
		map.put("os", list);
		for (Order_ o : list) {
			System.out.println(o);
		}
		return "/admin/listOrder";
	}
}
