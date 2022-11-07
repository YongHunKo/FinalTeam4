package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.WishlistDTO;
import com.multi.service.WishlistService;

@Controller
public class MainController {
	
	@Autowired
	WishlistService wishservice;

	@RequestMapping("/")
	public String main(String custid, Model model) {
		List<WishlistDTO> list = null;
		try {
			list = wishservice.viewwish(custid);
			model.addAttribute("viewwish", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "index";
	}



	@RequestMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("center", "login");
		
		return "index";
	}



}
