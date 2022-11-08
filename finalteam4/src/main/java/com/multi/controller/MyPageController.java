package com.multi.controller;

import java.util.List;

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
//	@RequestMapping("/orderdetail")
//	public String orderdetail(Integer id, Model model) {
//		OrderlistDTO list_one = null;
//		List<OrderlistDTO> list = null;
//		try {
//			list_one = order_service.myorder_1(id);
//			list = order_service.myorder(id);
//			model.addAttribute("list_one", list_one);
//			model.addAttribute("orderlist", list);
//			model.addAttribute("center", dir + "orderdetail");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "index";
//	}

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
	
	@RequestMapping("/wishlist")
	public String wishlist(String id, Model model) {
		List<WishlistDTO> list = null;
		OrderlistDTO list_one = null;
		try {
			list = wishservice.viewwish(id);
			list_one = order_service.myorder_1(id);
			model.addAttribute("list_one", list_one);
			model.addAttribute("viewwish", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir + "wishlist");
		return "index";
	}
}
