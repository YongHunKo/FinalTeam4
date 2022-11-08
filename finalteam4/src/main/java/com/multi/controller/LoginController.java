package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustDTO;
import com.multi.dto.StoreimgDTO;
import com.multi.dto.WishlistDTO;
import com.multi.service.CustService;
import com.multi.service.StoreimgService;
import com.multi.service.WishlistService;

@Controller
public class LoginController {

	@Autowired
	CustService service;
	
	@Autowired
	WishlistService wishservice;
	
	@Autowired
	StoreimgService imgservice;
	
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
		List<StoreimgDTO> list2=null;
		List<StoreimgDTO> list3=null;
		
		try {
			cust = service.get(custid);
			list2=imgservice.selectrandom();
			list3=imgservice.selectrandominfo();
			if(cust != null) {
				if(cust.getCustpwd().equals(custpwd)) {	
				session.setAttribute("logincust", cust);
				model.addAttribute("center", "maincenter");
				model.addAttribute("randomimg", list2);
				model.addAttribute("randominfo", list3);
				}else {
					model.addAttribute("center", "loginfail");
				}
				List<WishlistDTO> list = null;
				list = wishservice.viewwish(custid);
				model.addAttribute("viewwish", list);
			}
		} catch (Exception e) {
			
		}
		return "index";
	}

	
	
}
