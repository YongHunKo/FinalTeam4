package com.multi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CartDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.dto.ReserveDTO;
import com.multi.dto.StoreimgDTO;
import com.multi.dto.WishlistDTO;
import com.multi.service.CartService;
import com.multi.service.OrderlistService;
import com.multi.service.ReserveService;
import com.multi.service.StoreService;
import com.multi.service.StoreimgService;
import com.multi.service.WishlistService;

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
	@Autowired
	StoreimgService imgservice;
	@Autowired
	WishlistService wishservice;
	@Autowired
	OrderlistService orderservice;

	/**
	 * reserveimpl 해당 메소드는 cart에 저장되어 있는 DB를 파라메터 custid 값을 통해 selectcart를 사용하여 찾아서,
	 * reserve에 사용하기 위한 목적이다 .
	 * 
	 * @param model
	 * @param custid
	 * @return
	 */
	@RequestMapping("/reserveimpl")
	public String reserveimpl(Model model, String custid) {
		List<CartDTO> list = null;
		try {
			list = cartservice.selectcart(custid);
			model.addAttribute("menulist", list);
			model.addAttribute("center", "/reserve");
			for (CartDTO c : list) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	/**
	 * reserveimpl2 해당 메소드는 custid를 통해 selectcart를 하여, 추출된 데이터들을 order에 넣고
	 * register하는 동시에 바로 직전에 생긴 order의 orderlistno를 reserve에 register하면서, cart에 담겨진
	 * DB를 delete하며 하나의 주문번호로 여러메뉴를 reserve하기 위한 목적이다.
	 * 
	 * @param cart
	 * @param custid
	 * @param reservedate
	 * @param reservetime
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/reserveimpl2")
	public String reserveimpl2(CartDTO cart, String custid, String reservedate, String reservetime, Model model)
			throws ParseException {
		List<CartDTO> list = null;
		
		List<StoreimgDTO> list2 = null;
		List<StoreimgDTO> list3 = null;
		List<StoreimgDTO> list4 = null;
		List<StoreimgDTO> list5 = null;
		List<StoreimgDTO> list6 = null;
		
		List<WishlistDTO> list7 = null;
		OrderlistDTO list8 = null;
		
		int cnt = 0;
		int totalprice = 0;
		int price = 0;
		Date dt1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(reservedate);
		String reservedate2 = new SimpleDateFormat("yyyy-MM-dd").format(dt1);
		Date dt2 = new SimpleDateFormat("yyyy-mm-dd hh:mm").parse(reservetime);
		String reservetime2 = new SimpleDateFormat("HH:mm").format(dt2);
		try {
			list = cartservice.selectcart(custid);
			for (CartDTO c : list) {
				cnt += c.getCnt();
				price = c.getPrice();
				totalprice += c.getCnt() * c.getPrice();
			}
			OrderlistDTO order = new OrderlistDTO(null, custid, null, cnt, totalprice, reservedate2, reservetime2, null,
					null);
			orderlistservice.register(order);
			int r = order.getOrderlistno();

			for (CartDTO c : list) {
				int cnt2 = c.getCnt();
				if (cnt2 == 0) {
					cartservice.remove(c.getCartid());
				} else {
					ReserveDTO reserve = new ReserveDTO(null, r, c.getMenuid(), c.getCnt(), c.getPrice(), null, null,
							null, null, null, null, null, null);
					reserveservice.register(reserve);
					cartservice.remove(c.getCartid());
				}
			}
			model.addAttribute("center", "/reservesuccess");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	/**
	 * updatecart reserve.html상에서 수량의 '수정'버튼을 누르면 cart를 통해 updatecart가 실행되며, 수량이
	 * 정정되는 것이 목적이다.
	 * 
	 * @param cart
	 * @param custid
	 * @return
	 */
	@PostMapping("/updatecart")
	public String updateCart(CartDTO cart, String custid) {
		try {
			cartservice.updatecart(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:reserveimpl?custid=" + cart.getCustid();
	}
}
