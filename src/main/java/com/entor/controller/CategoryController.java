package com.entor.controller;

import java.io.File;
import java.io.IOException;
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
import com.entor.entity.User;
import com.entor.service.CategoryService;
import com.entor.service.UserService;

@Controller
public class CategoryController {

	@Resource
	private CategoryService categoryService;
	@RequestMapping("/admin_category_add")
	public String admin_category_add(MultipartFile image,HttpServletRequest request) throws IllegalStateException, IOException{ 
		String path = request.getServletContext().getRealPath("/img/category/");
		String name = request.getParameter("name");
		/*if(image!=null) {
			//文件类型
			String contentType = image.getContentType();
			//获取文件后缀
//			String lastname = image.getName().substring(image.getName().lastIndexOf(".")+1);
			String lastname = String.valueOf(image.getOriginalFilename().lastIndexOf(".")+1);

			Category category = new Category();
			category.setName(name);
			categoryService.add(category);
			int id = category.getId();
			String file = image.getOriginalFilename();
			//文件名称
			String fileName =String.valueOf(id)+".jpg";
			//文件大小
			long size = image.getSize();
			System.out.println("文件类型"+contentType);
			System.out.println("文件名称"+fileName);
			System.out.println("文件大小"+size);
			//上传文件
			image.transferTo(new File(path,fileName));
		}*/
		upload(image, path, name);
		return "redirect:/listCategory/1";
	}
	@RequestMapping("admin_category_edit/{id}/{currentPage}")
	public String admin_category_edit(@PathVariable int id,@PathVariable int currentPage,Map<String, Object> map) {
		Category category = categoryService.queryById(Category.class, id);
		map.put("c", category);
		map.put("sp", currentPage);
		return "admin/editCategory";
	}
	@RequestMapping("admin_category_update")
	public String admin_category_update(MultipartFile image,HttpServletRequest request) throws IllegalStateException, IOException {
		String path = request.getServletContext().getRealPath("/img/category/");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String currentPage = request.getParameter("sp");
		upload(image, path, name);
		Category c = new Category();
		c.setId(id);
		c.setName(name);
		categoryService.update(c);
		return "redirect:/listCategory/"+currentPage;
	}
	@RequestMapping("admin_category_delete/{id}/{currentPage}")
	public String admin_category_delete(@PathVariable String id,@PathVariable String currentPage) {
		categoryService.deleteById(Category.class, Integer.parseInt(id));
		return "redirect:/listCategory/"+currentPage;
	}
	@RequestMapping("category_queryByPage")
	private String queryByPage(){
		return "redirect:/listCategory/1";
	}
	@RequestMapping("/listCategory/{currentPage}")
	public String listCategory(@PathVariable String currentPage,Map<String, Object> map) {
		int sp = 1;
		int pageSize = 5;
		int totals = categoryService.getTotals(Category.class);
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
		List<Category> list = categoryService.queryByPage(Category.class, sp, pageSize);
		map.put("name", "listCategory");
		map.put("totals", totals);
		map.put("sp", sp);
		map.put("pageCounts", pageCounts);
		map.put("cs", list);
		return "/admin/listCategory";
	}
	
	public void upload(MultipartFile image,String path,String name) throws IllegalStateException, IOException {
		if(image!=null) {
			//文件类型
			String contentType = image.getContentType();
			//获取文件后缀
//			String lastname = image.getName().substring(image.getName().lastIndexOf(".")+1);
			String lastname = String.valueOf(image.getOriginalFilename().lastIndexOf(".")+1);

			//可以加个判断
			Category category = new Category();
			category.setName(name);
			categoryService.add(category);
			int id = category.getId();
			String file = image.getOriginalFilename();
			//文件名称
			String fileName =String.valueOf(id)+".jpg";
			//文件大小
			long size = image.getSize();
			System.out.println("文件类型"+contentType);
			System.out.println("文件名称"+fileName);
			System.out.println("文件大小"+size);
			//上传文件
			image.transferTo(new File(path,fileName));
		}
	}
}
