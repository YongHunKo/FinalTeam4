package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustDTO;
import com.multi.service.CustService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

	@Autowired
	CustService cust_service;

	String dir = "mypage/";

	@RequestMapping("")
	public String mypage(Model model) {
		model.addAttribute("center", dir + "mypage");
		return "index";
	}
	
	@RequestMapping("/edit")
	public String edit(String id, Model model) {
		CustDTO cust = null;
		try {
			cust = cust_service.get(id);
			model.addAttribute("custedit", cust);
			model.addAttribute("center", dir + "edit");
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
