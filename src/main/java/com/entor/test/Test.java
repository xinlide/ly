package com.entor.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.entity.Category;
import com.entor.entity.User;
import com.entor.service.CategoryService;
import com.entor.service.UserService;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService)context.getBean("categoryService");
		/*User user = service.queryById(User.class, 16);
		System.out.println(user);*/
		List<Category> list = service.queryByPage(Category.class, 1, 20);
		for (Category category : list) {
			System.out.println(category);
		}
	}
}
