package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.MenuDTO;
import com.multi.dto.StoreDTO;
import com.multi.service.MenuService;
import com.multi.service.StoreService;

@Controller
public class SearchController {
	
	@Autowired
	MenuService menuservice;
	@Autowired
	StoreService storeservice;
	
	@RequestMapping("/searchimpl")
	public String logout(Model model, String txt) {
		List<MenuDTO> list = null;
		List<StoreDTO> list2 = null;
		try {
			list = menuservice.searchmenu(txt);
			list2 = storeservice.searchstore(txt);
			model.addAttribute("menulist",list);
			model.addAttribute("storelist",list2);
			model.addAttribute("center","search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}
