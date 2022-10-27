package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.MenuDTO;
import com.multi.service.MenuService;

@Controller
public class SearchController {
	
	@Autowired
	MenuService menuservice;
	
	@RequestMapping("/searchimpl")
	public String logout(Model model, String txt) {
		List<MenuDTO> list = null;
		try {
			list = menuservice.searchmenu(txt);
			model.addAttribute("menulist",list);
			model.addAttribute("center","search");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}
