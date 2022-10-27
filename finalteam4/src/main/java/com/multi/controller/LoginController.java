package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustDTO;
import com.multi.service.CustService;

@Controller
public class LoginController {

	@Autowired
	CustService service;
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		return "index";
	}

	
	
	
	@RequestMapping("/loginimpl")
	public String loginimpl(HttpSession session, String custid, String custpwd, Model model) {
		CustDTO cust = null;
		System.out.println("in");
		try {
			cust = service.get(custid);
			if(cust != null) {
				if(cust.getCustpwd().equals(custpwd)) {	
				session.setAttribute("logincust", cust);
				model.addAttribute("center", "maincenter");
				}else {
					model.addAttribute("center", "loginfail");
				}
			}
		} catch (Exception e) {
			
		}
		return "index";
	}

	
	
}
