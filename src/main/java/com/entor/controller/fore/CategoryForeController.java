package com.entor.controller.fore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.entity.Category;
import com.entor.entity.Product;
import com.entor.entity.Productimage;
import com.entor.entity.User;
import com.entor.service.CategoryService;
import com.entor.service.ProductImageService;
import com.entor.service.ProductService;
import com.entor.service.UserService;

@Controller
public class CategoryForeController {

	@Resource
	private CategoryService categoryService;
	@Resource
	private ProductService productService;
	@Resource
	private ProductImageService productImageService;
	@RequestMapping("forecategory/{cid}")
	public String forecategory(@PathVariable int cid,Map<String, Object> map) {
		List<Product> plist = productService.queryByCid(cid);
		List<Product> nlist = new ArrayList<>(); 
		for (Product p : plist) {
			int pid = p.getId();
			Productimage pimg = productImageService.queryByPid(pid);
			p.setFirstProductImage(pimg);
			nlist.add(p);
		}
		Category c = categoryService.queryById(Category.class, cid);
		c.setProducts(plist);
		map.put("c", c);
		return "/fore/category";
	}
	
}
