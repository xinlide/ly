package com.entor.controller.fore;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.entity.Orderitem;
import com.entor.entity.Product;
import com.entor.entity.Productimage;
import com.entor.entity.User;
import com.entor.service.OrderService;
import com.entor.service.OrderitemService;
import com.entor.service.ProductImageService;

@Controller
public class ForeCartContert {

	@Resource
	private OrderitemService orderitemService;
	@Resource
	private ProductImageService productImageService;
	
	@RequestMapping("forecart")
	public String forecart(HttpSession session,Map<String, Object> map) {
		User user = (User) session.getAttribute("user");
		
		List<Orderitem> ois = orderitemService.queryByUid(user.getId());
		for (Orderitem oi : ois) {
			int pid = oi.getProduct().getId();
			Productimage pimg = productImageService.queryByPid(pid);
			oi.getProduct().setFirstProductImage(pimg);
		}
		map.put("ois", ois);
		return "fore/cart";
	}
	
	@RequestMapping("foreaddCart")
	@ResponseBody
	public String foreaddCart(int pid,int num,HttpSession session) {
		User user = (User) session.getAttribute("user");
		Orderitem oi = orderitemService.queryByPidAndUid(pid,user.getId());
		if(oi == null) {
			Orderitem noi = new Orderitem();
			Product p = new Product();
			Productimage pimg = productImageService.queryByPid(pid);
			p.setId(pid);
			p.setFirstProductImage(pimg);
			noi.setProduct(p);
			noi.setUser(user);
			noi.setNumber(num);
			orderitemService.add(noi);
			return "success";
		}
		oi.setNumber(oi.getNumber()+num);
		/**/
		orderitemService.update(oi);
		return "success";
	}
}
