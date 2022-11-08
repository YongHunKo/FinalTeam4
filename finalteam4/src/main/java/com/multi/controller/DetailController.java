package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.StoreDTO;
import com.multi.service.StoreService;

@Controller
public class DetailController {
	
	@Autowired
	StoreService service;

	@RequestMapping("/cafedetail")
	public String cafedetail(Model model) {
		List<StoreDTO> list = null;
		List<StoreDTO> list2 =null;
		try {
			list=service.cafedetail(200);
			list2=service.detailimg(200);
			model.addAttribute("detail", list);
			model.addAttribute("all", list2);
			model.addAttribute("center", "cafedetail");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		return "index";
	}
	
	@RequestMapping("/sushidetail")
	public String sushidetail(Model model) {
		model.addAttribute("center", "cafedetail");
		return "index";
	}
	
	@RequestMapping("/porkdetail")
	public String porkdetail(Model model) {
		model.addAttribute("center", "cafedetail");
		return "index";
	}
	
	
	
	
	
}
