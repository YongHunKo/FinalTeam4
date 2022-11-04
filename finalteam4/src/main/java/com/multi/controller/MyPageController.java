package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.dto.ReviewDTO;
import com.multi.service.CustService;
import com.multi.service.OrderlistService;
import com.multi.service.ReviewService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

	@Autowired
	CustService cust_service;

	@Autowired
	OrderlistService order_service;

	@Autowired
	ReviewService review_service;

	String dir = "mypage/";

	@RequestMapping("")
	public String mypage(String id, Model model) {
		OrderlistDTO list1 = null;
		List<OrderlistDTO> list2 = null;
		try {
			list1 = order_service.myorder_1(id);
			list2 = order_service.myorder(id);
			model.addAttribute("list1", list1);
			model.addAttribute("list2", list2);
			model.addAttribute("center", dir + "mypage");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("/review")
	public String review(String id, Model model) {
		OrderlistDTO list1 = null;
		List<ReviewDTO> list = null;
		try {
			list1 = order_service.myorder_1(id);
			list = review_service.myreview(id);
			model.addAttribute("list1", list1);
			model.addAttribute("list", list);
			model.addAttribute("center", dir + "review");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

//	@RequestMapping("/review")
//	public String review(String id, Model model) {
//		List<ReviewDTO> list = null;
//		try {
//			list = order_service.myorder(id);
//			model.addAttribute("list", list);			
//			model.addAttribute("center", dir + "review");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "index";
//	}

	@RequestMapping("/edit")
	public String edit(String id, Model model) {
		OrderlistDTO list1 = null;
		CustDTO cust = null;
		try {
			list1 = order_service.myorder_1(id);
			cust = cust_service.get(id);
			model.addAttribute("list1", list1);
			model.addAttribute("custedit", cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir + "edit");
		return "index";
	}

	@RequestMapping("/updateimpl")
	public String updateimpl(CustDTO cust, Model model) {
		try {
			cust_service.modify(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/mypage";
	}
}
