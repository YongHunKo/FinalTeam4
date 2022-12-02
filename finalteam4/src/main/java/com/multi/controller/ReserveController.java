package com.multi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CartDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.dto.ReserveDTO;
import com.multi.dto.StoreDTO;
import com.multi.dto.StoreimgDTO;
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
	public String reserveimpl(Model model, String custid, Integer storeid, HttpSession session) {
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
	public String reserveimpl2(CartDTO cart, String custid, String reservedate, Model model) {
		List<CartDTO> list = null;

		int cnt = 0;
		int totalprice = 0;
		int price = 0;

		SimpleDateFormat reserveFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		SimpleDateFormat reservedateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat reservetimeFormat = new SimpleDateFormat("HH:mm");
		try {
			Date reserve2 = reserveFormat.parse(reservedate);
			String reservedate2 = reservedateFormat.format(reserve2);
			String reservetime2 = reservetimeFormat.format(reserve2);
			list = cartservice.selectcart(custid);
			for (CartDTO c : list) {
				cnt += c.getCnt();
				price = c.getPrice();
				totalprice += c.getCnt() * c.getPrice();
			}
			OrderlistDTO order = new OrderlistDTO(null, custid, null, cnt, totalprice, reservedate2, reservetime2, null,
					null,null,null);
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

					List<ReserveDTO> list2 = reserveservice.myreserve(r);
					model.addAttribute("list2", list2);
				}
			}

			OrderlistDTO list3 = null;
			list3 = orderlistservice.get(r);
			model.addAttribute("list3", list3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 이부분이 고장남 어떻게 해결해야할까
		// 일단 냅두고 고쳐보자
		model.addAttribute("center", "/reservesuccess");
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
	public String updateCart(CartDTO cart, String custid, String adminid, HttpSession session, Model model) {
		System.out.println(adminid);
		List<CartDTO> list = null;
		Integer storeid = null;
		//얘를 어찌보낼까 
		try {
			cartservice.updatecart(cart);
			list = cartservice.selectcart(custid);
			model.addAttribute("menulist", list);
			//storeid를 뽑아내려면 어떤걸 써야하나
			//get으로 가져온다?
			for(CartDTO c:list) {
				storeid = c.getStoreid();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:reserveimpl?custid=" + cart.getCustid()+"&storeid="+storeid;
	}
}
