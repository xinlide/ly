package com.entor.controller.fore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.dao.UserDao;
import com.entor.entity.Order_;
import com.entor.entity.Orderitem;
import com.entor.entity.Product;
import com.entor.entity.User;
import com.entor.service.OrderService;
import com.entor.service.OrderitemService;
import com.entor.service.ProductImageService;
import com.entor.service.ProductService;
import com.entor.service.UserService;
import com.mysql.fabric.xmlrpc.base.Array;

@Controller
public class BuyController {

	@Resource
	private OrderService orderService;
	@Resource
	private OrderitemService orderitemService;
	@Resource
	private ProductService productService;
	@Resource
	private ProductImageService productImageService;
	@RequestMapping("/forebuyone/{pid}")
	private String order_queryByPage(@PathVariable String pid,Map<String, String>map) {
		map.put("pid", pid);
		return "/fore/buy";
	}
	
	@RequestMapping("/forebuy")
	private String forebuy(String[] oiid ,Map<String, Object>map) {
		List<Orderitem> ois = new ArrayList<Orderitem>();
		float total = 0;
		for (String string : oiid) {
			Orderitem oi = orderitemService.queryById(Orderitem.class, string);
			Product p = productService.queryById(Product.class, oi.getProduct().getId()) ;
			p.setFirstProductImage(productImageService.queryByPid(oi.getProduct().getId()));
			oi.setProduct(p);
			float prices = oi.getNumber()*oi.getProduct().getPromotePrice();
			total += prices;
//			System.out.println(oi);
			ois.add(oi);
		}
		
		map.put("ois", ois);
		map.put("total", total);
		return "/fore/buy";
	}
	
	@RequestMapping("forecreateOrder")
	public String forecreateOrder(Order_ o,String total,Map<String, Object> map,HttpSession session) {
//		List<String> param = new ArrayList<>();
		//生成订单号
		Random random = new Random();
	    SimpleDateFormat allTime = new SimpleDateFormat("YYYYMMddHHmmSSms");
	    String subjectno = allTime.format(new Date())+random.nextInt(10);       
	    String orderCode = subjectno+random.nextInt(10);
	    o.setOrderCode(orderCode);
		User user = (User)session.getAttribute("user");
		o.setUser(user);
		o.setStatus("WaitPay");
		orderService.add(o);
		map.put("param.oid", String.valueOf(o.getId()));
//		System.out.println(map);
		map.put("param.total", total);
//		System.out.println(map);
		return "fore/alipay";
	}
	
	@RequestMapping("forepayed")
	public String forepayed(int oid,int total) {
//		orderService.update(oid);
		return "";
	}
}
