package com.multi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.attoparser.config.ParseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CartDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.dto.ReserveDTO;
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "index";
	}
	
	@RequestMapping("/reserveimpl2")
	public String reserveimpl2(CartDTO cart,String custid, String reservedate, String reservetime) throws ParseException {
		List<CartDTO> list = null;
		int cnt = 0;
		int totalprice = 0;
		int price = 0;
		Date dt1 = new SimpleDateFormat("yyyy-mm-dd HH:mm").parse(reservedate);
		String reservedate2 = new SimpleDateFormat("yyyy-MM-dd").format(dt1);
		Date dt2 = new SimpleDateFormat("yyyy-mm-dd hh:mm").parse(reservetime);
		String reservetime2 = new SimpleDateFormat("HH:mm").format(dt2);
		try {
			list = cartservice.selectcart(custid);
			for(CartDTO c:list) {
				cnt += c.getCnt();
				price = c.getPrice();
				totalprice += c.getCnt()*c.getPrice();
			}
			OrderlistDTO order = new OrderlistDTO(null, custid, null, cnt, totalprice, reservedate2, reservetime2, null, null);
			orderlistservice.register(order);
			int r = order.getOrderlistno();
			
			for(CartDTO c:list) {
				int cnt2 = c.getCnt();
				if(cnt2 == 0) {
					cartservice.remove(c.getCartid());
				}else {
					ReserveDTO reserve = new ReserveDTO(null, r, c.getMenuid(), c.getCnt(), c.getPrice(), null, null, null, null, null, null, null);
					reserveservice.register(reserve);
					cartservice.remove(c.getCartid());					
				}
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
