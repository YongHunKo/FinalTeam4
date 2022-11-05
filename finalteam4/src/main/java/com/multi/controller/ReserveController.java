package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CartDTO;
import com.multi.dto.StoreDTO;
import com.multi.service.CartService;
import com.multi.service.StoreService;

@Controller
public class ReserveController {
	@Autowired
	StoreService storeservice;
	@Autowired
	CartService cartservice;
	
	@RequestMapping("/reserveimpl")
	public String reserveimpl(Model model, String custid) {
//		List<StoreDTO>list = null;
//		try {
//			list = storeservice.detail(storeid);
//			model.addAttribute("menulist",list);
//			model.addAttribute("center","/reserve");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		List<CartDTO> list = null;
		try {
			list = cartservice.selectcart(custid);
			model.addAttribute("menulist",list);
			model.addAttribute("center","/reserve");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@PostMapping("/updatecart")
	public String updateCartPOST(CartDTO cart,String custid) {
		
		try {
			cartservice.updatecart(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:reserveimpl?custid=" + cart.getCustid();
		
		
	}	

}
