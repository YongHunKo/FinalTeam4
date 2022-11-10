package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.OrderlistDTO;
import com.multi.dto.StoreimgDTO;
import com.multi.dto.WishlistDTO;
import com.multi.service.OrderlistService;
import com.multi.service.StoreimgService;
import com.multi.service.WishlistService;

@Controller
public class MainController {

	@Autowired
	StoreimgService imgservice;
	@Autowired
	WishlistService wishservice;
	@Autowired
	OrderlistService orderservice;
	
	
	
	@RequestMapping("/")
	public String main(Model model, String id) {
		List<StoreimgDTO> list2=null;
		List<StoreimgDTO> list3=null;
		List<StoreimgDTO> list4=null;
		List<StoreimgDTO> list5=null;
		List<StoreimgDTO> list6=null;
		
		List<WishlistDTO> list7 = null;
		OrderlistDTO list8 = null;
		try {
			list2 = imgservice.selectrandom();
			list3 = imgservice.selectrandominfo();
			list4 = imgservice.today();
			list5 = imgservice.today2();
			list6 = imgservice.today3();
			
			list7 = wishservice.viewwish(id);
			list8 = orderservice.myorder_1(id);
			
			model.addAttribute("viewwish", list7);
			model.addAttribute("list_one", list8);
			
			model.addAttribute("randomimg", list2);
			model.addAttribute("randominfo", list3);
			model.addAttribute("today", list4);
			model.addAttribute("todaytwo", list5);
			model.addAttribute("todaythree", list6);
			model.addAttribute("center", "maincenter");
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
	
	@RequestMapping("/wishlist")
	public String wishlist(String id, Model model) {
		List<WishlistDTO> list = null;
		OrderlistDTO list_one = null;
		try {
			list = wishservice.viewwish(id);
			list_one = orderservice.myorder_1(id);
			model.addAttribute("list_one", list_one);
			model.addAttribute("viewwish", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", "wishlist");
		return "index";
	}



}
