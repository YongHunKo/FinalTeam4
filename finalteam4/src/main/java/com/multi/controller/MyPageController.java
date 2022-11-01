package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.service.CustService;
import com.multi.service.OrderlistService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

	@Autowired
	CustService cust_service;
	
	@Autowired
	OrderlistService order_service;

	String dir = "mypage/";

	@RequestMapping("")
	public String mypage(String id, Model model) {
		List<OrderlistDTO> list = null;
		try {
		list = order_service.myorder(id);
		model.addAttribute("list", list);			
		model.addAttribute("center", dir + "mypage");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/edit")
	public String edit(String id, Model model) {
		CustDTO cust = null;
		try {
			cust = cust_service.get(id);
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
