package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.StoreDTO;
import com.multi.dto.StoreimgDTO;
import com.multi.service.StoreService;
import com.multi.service.StoreimgService;

@Controller
public class DetailController {
	
	@Autowired
	StoreService service;
	
	@Autowired
	StoreimgService storeimgservice;
	

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
		List<StoreDTO> list = null;
		List<StoreDTO> list2 =null;
		try {
			list=service.cafedetail(310);
			list2=service.detailimg(310);
			model.addAttribute("center", "sushidetail");
			model.addAttribute("detail", list);
			model.addAttribute("all", list2);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@RequestMapping("/porkdetail")
	public String porkdetail(Model model) {
		List<StoreDTO> list = null;
		List<StoreDTO> list2 =null;
		try {
			list=service.cafedetail(110);
			list2=service.detailimg(110);
			model.addAttribute("center", "porkdetail");
			model.addAttribute("detail", list);
			model.addAttribute("all", list2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	
	
	
	
	
}
