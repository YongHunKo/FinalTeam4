package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.StoreimgDTO;
import com.multi.service.StoreimgService;

@Controller
public class MainController {

	@Autowired
	StoreimgService imgservice;
	
	
	
	@RequestMapping("/")
	public String main(Model model) {
		List<StoreimgDTO> list2=null;
		List<StoreimgDTO> list3=null;
		List<StoreimgDTO> list4=null;
		List<StoreimgDTO> list5=null;
		List<StoreimgDTO> list6=null;
		try {
			list2 = imgservice.selectrandom();
			list3 = imgservice.selectrandominfo();
			list4 = imgservice.today();
			list5 = imgservice.today2();
			list6 = imgservice.today3();
			model.addAttribute("randomimg", list2);
			model.addAttribute("randominfo", list3);
			model.addAttribute("today", list4);
			model.addAttribute("todaytwo", list5);
			model.addAttribute("todaythree", list6);
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
