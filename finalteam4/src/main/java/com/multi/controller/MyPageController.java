package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.dto.ReserveDTO;
import com.multi.dto.ReviewDTO;
import com.multi.dto.WishlistDTO;
import com.multi.service.CustService;
import com.multi.service.OrderlistService;
import com.multi.service.ReserveService;
import com.multi.service.ReviewService;
import com.multi.service.WishlistService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

	@Autowired
	CustService cust_service;

	@Autowired
	OrderlistService order_service;

	@Autowired
	ReviewService review_service;

	@Autowired
	ReserveService reserve_service;

	@Autowired
	WishlistService wishservice;

	String dir = "mypage/";

	@RequestMapping("")
	public String mypage(String id, Model model) {
		OrderlistDTO list_one = null;
		try {
			list_one = order_service.myorder_1(id);
			model.addAttribute("list_one", list_one);
			model.addAttribute("center", dir + "mypage");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("/order")
	public String order(String id, Model model) {
		OrderlistDTO list_one = null;
		List<OrderlistDTO> list = null;
		try {
			list_one = order_service.myorder_1(id);
			list = order_service.myorder(id);
			model.addAttribute("list_one", list_one);
			model.addAttribute("orderlist", list);
			model.addAttribute("center", dir + "order");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("/orderdetail")
	public String orderdetail(Integer id, Model model, HttpSession session) {
		Object obj = session.getAttribute("logincust");
		CustDTO cust = (CustDTO) obj;
		String custid = cust.getCustid();

		OrderlistDTO list_one = null;
		List<ReserveDTO> list = null;
		String storeid = null;
		int cnt = 0;
		int total = 0;
		try {
			list_one = order_service.myorder_1(custid);
			list = reserve_service.myreserve(id);
			storeid = list.get(0).getStoreid();
			for (ReserveDTO r : list) {
				cnt += r.getCnt();
				total += r.getOrderprice();
			}
			model.addAttribute("list_one", list_one);
			model.addAttribute("list", list);
			model.addAttribute("storeid", storeid);
			model.addAttribute("cnt", cnt);
			model.addAttribute("total", total);
			model.addAttribute("center", dir + "orderdetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return "index";
	}

	@RequestMapping("/ocr")
	public String ocr(String id, Model model, HttpSession session) {
		Object obj = session.getAttribute("logincust");
		CustDTO cust = (CustDTO) obj;
		String custid = cust.getCustid();

		OrderlistDTO list_one = null;
		try {
			list_one = order_service.myorder_1(custid);
			model.addAttribute("list_one", list_one);
			model.addAttribute("storeid", id);
			model.addAttribute("center", dir + "ocr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("/review")
	public String review(String id, Model model) {
		OrderlistDTO list_one = null;
		List<ReviewDTO> review = null;
		try {
			list_one = order_service.myorder_1(id);
			review = review_service.myreview(id);
			model.addAttribute("list_one", list_one);
			model.addAttribute("review", review);
			model.addAttribute("center", dir + "review");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(review);
		return "index";
	}

	@RequestMapping("/edit")
	public String edit(String id, Model model) {
		OrderlistDTO list_one = null;
		try {
			list_one = order_service.myorder_1(id);
			model.addAttribute("list_one", list_one);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir + "edit");
		return "index";
	}

	@RequestMapping("/info")
	public String info(String id, Model model) {
		OrderlistDTO list_one = null;
		try {
			list_one = order_service.myorder_1(id);
			model.addAttribute("list_one", list_one);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir + "info");
		return "index";
	}

	@RequestMapping("/deletewishlist")
	public String deletewishlist(Model model, int wishlistid, String id) {
		try {
			wishservice.remove(wishlistid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/mypage/wishlist?id=" + id;
	}
}
