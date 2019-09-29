package com.entor.controller.fore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.dao.UserDao;
import com.entor.entity.Category;
import com.entor.entity.Order_;
import com.entor.entity.Product;
import com.entor.entity.Productimage;
import com.entor.entity.User;
import com.entor.service.CategoryService;
import com.entor.service.OrderService;
import com.entor.service.ProductImageService;
import com.entor.service.ProductService;
import com.entor.service.UserService;

@Controller
public class HomeController {

	@Resource
	private CategoryService categoryService;
	@Resource
	private ProductService productService;
	@Resource
	private ProductImageService productImageService;
	
	@RequestMapping("forehome")
	public String forehome(Map<String, Object> map) {
		List<Category> cs  = new ArrayList<Category>();
		List<Category> clist = categoryService.queryAll();
		for (Category category : clist) {
			List<Product> plist = productService.queryByCid(category.getId());
			category.setProductsByRow(plist);
			List<Product> plists = new ArrayList<>(); 
			for (Product p : plist) {
				Productimage pimg = productImageService.queryByPid(p.getId());
				p.setFirstProductImage(pimg);
				plists.add(p);
			}
			category.setProducts(plists);
			cs.add(category);
		}
		map.put("cs", cs);
		System.out.println(cs);
		/*for (Category c : cs) {
			for (Product ps : c.getProductsByRow()) {
				System.out.println(ps);
			}
		}*/
		return "/fore/home";
	}
	
}
