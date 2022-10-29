package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustDTO;
import com.multi.service.CustService;

@Controller
public class SignupController {
	
	@Autowired
	CustService cust_service;
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("center", "signup");
		return "index";
	}
	
	@RequestMapping("/signupimpl")
	public String signupimpl(Model model, CustDTO cust, HttpSession session) {
		try {
			cust_service.register(cust);
			session.setAttribute("logincust",cust);
			model.addAttribute("center", "signupok");
			model.addAttribute("rid", cust);
		} catch (Exception e) {
			model.addAttribute("center", "signupfail");
			model.addAttribute("fid", cust.getCustid());
		}
		return "index";
	}
}

