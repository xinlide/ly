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
import com.entor.entity.User;
import com.entor.service.CategoryService;
import com.entor.service.ProductImageService;
import com.entor.service.ProductService;
import com.entor.service.UserService;

@Controller
public class ProductImageController {

	@Resource
	private ProductService productService;
	@Resource
	private ProductImageService productImageService;
	@RequestMapping("/admin_productImage_list/{pid}")
	public String admin_productImage_list(@PathVariable int pid,Map<String, Object> map) {
		Product p = productService.queryById(Product.class, pid);
		List<Productimage> pisSingle = productImageService.queryTypeSingle(pid);
		List<Productimage> pisDetail = productImageService.queryTypeDetail(pid);
		map.put("p", p);
		map.put("pisSingle", pisSingle);
		map.put("pisDetail", pisDetail);
		return "admin/listProductImage";
	}
}
