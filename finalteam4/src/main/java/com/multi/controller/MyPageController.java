package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String edit(Model model) {
		model.addAttribute("center", dir + "edit");
		return "index";
	}
}
