package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.StoreDTO;
import com.multi.dto.StoreimgDTO;
import com.multi.dto.WishlistDTO;
import com.multi.service.StoreService;
import com.multi.service.StoreimgService;
import com.multi.service.WishlistService;

@Controller
public class StoreController {
	@Autowired
	StoreimgService storeimgservice;
	@Autowired
	StoreService storeservice;
	@Autowired
	WishlistService wishservice;
	
	@RequestMapping("/storedetail")
	public String storedetail(Model model, Integer storeid) {
		List<StoreimgDTO> list = null;
		List<StoreDTO> list2 = null;
		
		try {
			list = storeimgservice.selectstoreid(storeid);
			list2 = storeservice.detail(storeid);
			
			model.addAttribute("storeimglist",list);
			model.addAttribute("detaillist",list2);
			
			model.addAttribute("center","/detail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/insertwishlist")
	public String insertwishlist(Model mode, WishlistDTO wish) {
		try {
			wishservice.register(wish);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/storedetail?storeid="+wish.getStoreid();
	}

}
