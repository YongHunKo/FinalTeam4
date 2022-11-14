package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.StoreDTO;
import com.multi.service.StoreService;
import com.multi.service.StoreimgService;

@Controller
public class DetailController {
	
	@Autowired
	StoreService service;
	@Autowired
	StoreimgService storeimgservice;
	
	/**
	 * detail
	 * 카테고리 값들을 catedetail과 detailimg에 조회하여
	 *  해당 카테고리에 출력하는 것이 목적
	 * @param model
	 * @return
	 */
	@RequestMapping("/cafedetail")
	public String cafedetail(Model model) {
		List<StoreDTO> list = null;
		List<StoreDTO> list2 =null;
		try {
			list=service.catedetail(200);
			list2=service.detailimg(200);
			model.addAttribute("center", "cafedetail");
			model.addAttribute("detail", list);
			model.addAttribute("all", list2);
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
			list=service.catedetail(310);
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
			list=service.catedetail(110);
			list2=service.detailimg(110);
			model.addAttribute("center", "porkdetail");
			model.addAttribute("detail", list);
			model.addAttribute("all", list2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	
	
	
	
}
