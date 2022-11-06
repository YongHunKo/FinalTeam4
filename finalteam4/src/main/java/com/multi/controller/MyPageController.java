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
	
	@RequestMapping("/edit/reconfirm")
	public String reconfirm(String custid, String custpwd, Model model ) {
		CustDTO cust = null;
		try {
			cust cust_service.get(custid);
			if (cust.getCustpwd() != custpwd) {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
