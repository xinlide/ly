package com.entor.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.entor.dao.UserDao;
import com.entor.entity.Category;
import com.entor.entity.Product;
import com.entor.entity.Productimage;
import com.entor.entity.Propertyvalue;
import com.entor.entity.Review;
import com.entor.entity.User;
import com.entor.service.CategoryService;
import com.entor.service.OrderitemService;
import com.entor.service.ProductImageService;
import com.entor.service.ProductService;
import com.entor.service.PropertyValueService;
import com.entor.service.ReviewService;
import com.entor.service.UserService;

@Controller
public class ProductController {

	@Resource
	private ProductService productService;
	@Resource
	private ProductImageService productImageService;
	@Resource
	private PropertyValueService propertyValueService;
	@Resource
	private ReviewService reviewService;
	@Resource
	private OrderitemService orderitemService;
	
	@RequestMapping("admin_product_list/{cid}")
	private String queryByPage(@PathVariable String cid){
		return "redirect:/admin_product_list/"+cid+"/1";
	}
	@RequestMapping("admin_product_list/{cid}/{currentPage}")
	public String listCategory(@PathVariable String cid,@PathVariable String currentPage,Map<String, Object> map) {
		int sp = 1;
		int pageSize = 5;
		int totals = productService.getTotalsByCid(Product.class, Integer.parseInt(cid));
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
		List<Product> list = productService.queryPageByCid(Product.class,Integer.parseInt(cid), sp, pageSize);
		List<Product> nlist = new ArrayList<>(); 
		for (Product p : list) {
			int pid = p.getId();
			Productimage pimg = productImageService.queryByPid(pid);
			p.setFirstProductImage(pimg);
			nlist.add(p);
		}
		map.put("name", "listProduct");
		map.put("totals", totals);
		map.put("sp", sp);
		map.put("pageCounts", pageCounts);
		map.put("ps", nlist);
		return "/admin/listProduct";
	}
	
	/**
	 * 前端
	 */
	@RequestMapping("foreproduct/{pid}")
	public String foreproduct(@PathVariable int pid,Map<String, Object> map) {
		Product p = productService.queryByPid(Product.class, pid);
		p.setReviewCount(reviewService.getTotalsByPid(pid));
		p.setSaleCount(orderitemService.getSumNumberByPid(pid));
		List<Productimage> listPsingle = productImageService.queryTypeSingle(pid);
		List<Productimage> listPdetail = productImageService.queryTypeDetail(pid);
		List<Review> reviews = reviewService.queryByPid(pid);
		p.setProductSingleImages(listPsingle);
		p.setProductDetailImages(listPdetail);
		List<Propertyvalue> pvs = propertyValueService.queryByPid(pid);
		map.put("p", p);
		map.put("pvs", pvs);
		map.put("reviews", reviews);
		return "/fore/product";
	}
}
