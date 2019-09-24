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
import com.entor.entity.Property;
import com.entor.entity.User;
import com.entor.service.CategoryService;
import com.entor.service.PropertyService;
import com.entor.service.UserService;

@Controller
public class PropertyController {

	@Resource
	private PropertyService propertyService;
	
	@RequestMapping("property_queryByPage/{cid}")
	private String queryByPage(@PathVariable int cid) {
		return "redirect:/listProperty/1/"+cid;
	}
	@RequestMapping("/listProperty/{currentPage}/{cid}")
	public String listProperty(@PathVariable String currentPage,@PathVariable int cid,Map<String, Object> map) {
		int sp = 1;
		int pageSize = 5;
		int totals = propertyService.getTotals(Property.class);
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
		List<Property> list = propertyService.queryPageByCid(cid, Property.class, sp, pageSize);
		map.put("name", "listProperty");
		map.put("totals", totals);
		map.put("sp", sp);
		map.put("pageCounts", pageCounts);
		map.put("ps", list);
		return "/admin/listProperty";
	}
}
