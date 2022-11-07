package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CartDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.dto.ReserveDTO;
import com.multi.dto.StoreDTO;
import com.multi.service.CartService;
import com.multi.service.OrderlistService;
import com.multi.service.ReserveService;
import com.multi.service.StoreService;

@Controller
public class ReserveController {
	@Autowired
	StoreService storeservice;
	@Autowired
	CartService cartservice;
	@Autowired
	OrderlistService orderlistservice;
	@Autowired
	ReserveService reserveservice;
	
	@RequestMapping("/reserveimpl")
	public String reserveimpl(Model model, String custid) {
		List<CartDTO> list = null;
		try {
			list = cartservice.selectcart(custid);
			model.addAttribute("menulist",list);
			model.addAttribute("center","/reserve");
			for(CartDTO c:list) {
				System.out.println(c);
				//여기서 디비가 다 안넘어온다
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "index";
	}
	
	@RequestMapping("/reserveimpl2")
	public String reserveimpl2(CartDTO cart,String custid) {
		System.out.println(custid);
		List<CartDTO> list = null;
		int cnt = 0;
		int totalprice = 0;
		int price = 0;
		try {
			list = cartservice.selectcart(custid);
			for(CartDTO c:list) {
				System.out.println(c);//얘가 안불러와짐
				cnt += c.getCnt();
				price = c.getPrice();
				totalprice += c.getCnt()*c.getPrice();
			}
			OrderlistDTO order = new OrderlistDTO(null, custid, null, cnt, totalprice, null, null, custid, custid);
			orderlistservice.register(order);
			System.out.println(order);
			int r = order.getOrderlistno();
			
			for(CartDTO c:list) {
				ReserveDTO reserve = new ReserveDTO(null, r, c.getMenuid(), c.getCnt(), c.getPrice());
				reserveservice.register(reserve);
				cartservice.remove(c.getCartid());
			}					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";	
	}
	
	@PostMapping("/updatecart")
	public String updateCart(CartDTO cart,String custid) {		
		try {
			cartservice.updatecart(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "redirect:reserveimpl?custid=" + cart.getCustid();	
	}	
}
