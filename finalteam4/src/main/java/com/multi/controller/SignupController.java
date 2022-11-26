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

	/**
	 * signup 해당 메소드는 signup페이지에 가기 위한 메소드이다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("center", "signup");
		return "index";
	}

	/**
	 * signupimpl 해당 메소드는 signup페이지에서 파라메터 CustDTO를 받아, register를 하고 정상적으로 등록되었는지
	 * 판단하는 메소드이다.
	 * 
	 * @param model
	 * @param cust
	 * @param session
	 * @return
	 */
	@RequestMapping("/signupimpl")
	public String signupimpl(Model model, CustDTO cust, HttpSession session) {
		try {
			cust_service.register(cust);
			System.out.println(cust);
			session.setAttribute("logincust", cust);
			model.addAttribute("center", "signupok");
			model.addAttribute("rid", cust);
		} catch (Exception e) {
			model.addAttribute("center", "signupfail");
			model.addAttribute("fid", cust.getCustid());
		}
		return "index";
	}
}
